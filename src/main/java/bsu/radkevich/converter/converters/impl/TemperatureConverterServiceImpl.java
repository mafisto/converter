package bsu.radkevich.converter.converters.impl;

import bsu.radkevich.converter.converters.ConverterService;
import bsu.radkevich.converter.dto.ConvertDTO;
import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.DistanceType;
import bsu.radkevich.converter.dto.enums.TemperatureType;
import bsu.radkevich.converter.dto.enums.WeightType;

public class TemperatureConverterServiceImpl implements ConverterService {
    private static ConverterService instance = new TemperatureConverterServiceImpl();

    public static ConverterService getInstance() {
        return instance;
    }

    private static final Double GRAMS_IN_POUNDS = 453.592;

    @Override
    public ResponseDTO convert(RequestDTO dto) {
        Double value = dto.getValue();
        String sourceTypeValue = dto.getSourceType();
        String targetTypeValue = dto.getTargetType();
        TemperatureType sourceType = TemperatureType.fromValue(sourceTypeValue);
        TemperatureType targetType = TemperatureType.fromValue(targetTypeValue);
        ConvertDTO<TemperatureType> convertDTO = new ConvertDTO<>();
        convertDTO.setSourceType(sourceType);
        convertDTO.setTargetType(targetType);
        convertDTO.setValue(value);

        ResponseDTO resultDTO = proceedConvertion(convertDTO);
        return resultDTO;
    }

    private ResponseDTO proceedConvertion(ConvertDTO<TemperatureType> convertDTO) {
        TemperatureType targetType = convertDTO.getTargetType();
        TemperatureType sourceType = convertDTO.getSourceType();
        ResponseDTO result = new ResponseDTO();

        Double convertedValue = convertValue(convertDTO.getValue(), sourceType, targetType);
        result.setResultValue(convertedValue);
        result.setValueType(targetType.getValue());
        result.setConverterType(ConverterType.TEMPERATURE);
        return result;
    }

    private Double convertValue(Double value, TemperatureType sourceType, TemperatureType targetType) {
        Double convertedValue = value;

        if (sourceType.equals(TemperatureType.KELVIN) && targetType.equals(TemperatureType.CELSIUS)) {
            convertedValue = convertKelvinToCelsius(value, true);
        } else if (sourceType.equals(TemperatureType.CELSIUS) && targetType.equals(TemperatureType.KELVIN)) {
            convertedValue = convertKelvinToCelsius(value, false);
        }
        else if (sourceType.equals(TemperatureType.CELSIUS) && targetType.equals(TemperatureType.FAHRENHEIT)) {
            convertedValue = convertCelsiusToFahrenheit(value, true);
        } else if (sourceType.equals(TemperatureType.FAHRENHEIT) && targetType.equals(TemperatureType.CELSIUS)) {
            convertedValue = convertCelsiusToFahrenheit(value, false);
        }
        else if (sourceType.equals(TemperatureType.KELVIN) && targetType.equals(TemperatureType.FAHRENHEIT)) {
            convertedValue = convertKelvinToFahrenheit(value, true);
        } else if (sourceType.equals(TemperatureType.FAHRENHEIT) && targetType.equals(TemperatureType.KELVIN)) {
            convertedValue = convertKelvinToFahrenheit(value, false);
        }
        return convertedValue;
    }

    private Double convertKelvinToCelsius(Double value, boolean forward) {
        Double resultValue;
        if (forward) {
            Double celsiusValue = value - 273.15;
            resultValue = celsiusValue;
        } else {
            Double kelvinValue = value + 273.15;
            resultValue = kelvinValue;
        }
        return resultValue;

    }

    private Double convertKelvinToFahrenheit(Double value, boolean forward) {
        Double resultValue;
        if (forward) {
            Double fahrenheitValue = (value - 273.15) * 9 / 5 + 32;
            resultValue = fahrenheitValue;
        } else {
            Double kelvinValue = (value - 32) * 5 / 9 + 273.15;
            resultValue = kelvinValue;
        }
        return resultValue;
    }

    private Double convertCelsiusToFahrenheit(Double value, boolean forward) {
        Double resultValue;
        if (forward) {
            Double fahrenheitValue = (value) * 9 / 5 + 32;
            resultValue = fahrenheitValue;
        } else {
            Double celsiusValue = (value - 32) * 5 / 9;
            resultValue = celsiusValue;
        }
        return resultValue;
    }

}
