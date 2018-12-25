package bsu.radkevich.converter.converters.impl;

import bsu.radkevich.converter.converters.ConverterService;
import bsu.radkevich.converter.dto.ConvertDTO;
import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.DistanceType;

public class DistanceConverterServiceImpl implements ConverterService {
    private static ConverterService instance = new DistanceConverterServiceImpl();

    public static ConverterService getInstance() {
        return instance;
    }

    private static final Double MILE_IN_METRES = 1609.34;

    @Override
    public ResponseDTO convert(RequestDTO dto) {
        Double value = dto.getValue();
        String sourceTypeValue = dto.getSourceType();
        String targetTypeValue = dto.getTargetType();
        DistanceType sourceType = DistanceType.fromValue(sourceTypeValue);
        DistanceType targetType = DistanceType.fromValue(targetTypeValue);
        ConvertDTO<DistanceType> convertDTO = new ConvertDTO<>();
        convertDTO.setSourceType(sourceType);
        convertDTO.setTargetType(targetType);
        convertDTO.setValue(value);

        ResponseDTO resultDTO = proceedConvertion(convertDTO);
        return resultDTO;
    }

    private ResponseDTO proceedConvertion(ConvertDTO<DistanceType> convertDTO) {
        DistanceType targetType = convertDTO.getTargetType();
        DistanceType sourceType = convertDTO.getSourceType();
        ResponseDTO result = new ResponseDTO();

        Double convertedValue = convertValue(convertDTO.getValue(), sourceType, targetType);
        result.setResultValue(convertedValue);
        result.setValueType(targetType.getValue());
        result.setConverterType(ConverterType.DISTANCE);
        return result;
    }

    private Double convertValue(Double value, DistanceType sourceType, DistanceType targetType) {
        Double convertedValue = value;

        if (sourceType.equals(DistanceType.METRES) && targetType.equals(DistanceType.MILES)) {
            convertedValue = convertMilesToMetres(value, false);
        } else if (sourceType.equals(DistanceType.MILES) && targetType.equals(DistanceType.METRES)) {
            convertedValue = convertMilesToMetres(value, true);
        }
        return convertedValue;
    }


    private Double convertMilesToMetres(Double value, boolean forward) {
        Double convertedValue;
        if (forward) {
            Double metres = value * MILE_IN_METRES;
            convertedValue = metres;
        } else {
            if (value == 0) {
                return 0.0;
            }
            Double miles = value / MILE_IN_METRES;
            convertedValue = miles;
        }
        return convertedValue;
    }


}
