package bsu.radkevich.converter.converters.impl;

import bsu.radkevich.converter.converters.ConverterService;
import bsu.radkevich.converter.dto.ConvertDTO;
import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.DistanceType;
import bsu.radkevich.converter.dto.enums.WeightType;

public class WeightConverterServiceImpl implements ConverterService {
    private static ConverterService instance = new WeightConverterServiceImpl();

    public static ConverterService getInstance() {
        return instance;
    }

    private static final Double GRAMS_IN_POUNDS = 453.592;

    @Override
    public ResponseDTO convert(RequestDTO dto) {
        Double value = dto.getValue();
        String sourceTypeValue = dto.getSourceType();
        String targetTypeValue = dto.getTargetType();
        WeightType sourceType = WeightType.fromValue(sourceTypeValue);
        WeightType targetType = WeightType.fromValue(targetTypeValue);
        ConvertDTO<WeightType> convertDTO = new ConvertDTO<>();
        convertDTO.setSourceType(sourceType);
        convertDTO.setTargetType(targetType);
        convertDTO.setValue(value);

        ResponseDTO resultDTO = proceedConvertion(convertDTO);
        return resultDTO;
    }

    private ResponseDTO proceedConvertion(ConvertDTO<WeightType> convertDTO) {
        WeightType targetType = convertDTO.getTargetType();
        WeightType sourceType = convertDTO.getSourceType();
        ResponseDTO result = new ResponseDTO();

        Double convertedValue = convertValue(convertDTO.getValue(), sourceType, targetType);
        result.setResultValue(convertedValue);
        result.setValueType(targetType.getValue());
        result.setConverterType(ConverterType.WEIGHT);
        return result;
    }

    private Double convertValue(Double value, WeightType sourceType, WeightType targetType) {
        Double convertedValue = value;

        if (sourceType.equals(WeightType.GRAMS) && targetType.equals(WeightType.POUNDS)) {
            convertedValue = convertPoundsToGrams(value, false);
        } else if (sourceType.equals(WeightType.POUNDS) && targetType.equals(WeightType.GRAMS)) {
            convertedValue = convertPoundsToGrams(value, true);
        }
        return convertedValue;
    }

    private Double convertPoundsToGrams(Double value, boolean forward) {
        Double convertedValue;
        if (forward) {
            Double grams = value * GRAMS_IN_POUNDS;
            convertedValue = grams;
        } else {
            if (value == 0) {
                convertedValue = 0.0;
            } else {
                Double pounds = value / GRAMS_IN_POUNDS;
                convertedValue = pounds;
            }

        }
        return convertedValue;
    }

}
