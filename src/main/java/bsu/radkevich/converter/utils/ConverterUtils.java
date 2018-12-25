package bsu.radkevich.converter.utils;

import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.DistanceType;
import bsu.radkevich.converter.dto.enums.TemperatureType;
import bsu.radkevich.converter.dto.enums.WeightType;
import bsu.radkevich.converter.exceptions.ConversionException;

public class ConverterUtils {

    public static ConverterType resolveConverterType(RequestDTO dto) {
        validateDTO(dto);
        ConverterType type = getConverterTypeFromValue(dto);
        return type;
    }

    private static ConverterType resolveSourceValueType(String sourceTypeValue) {
        ConverterType type;

        if (DistanceType.fromValue(sourceTypeValue) != null) {
            type = ConverterType.DISTANCE;
        } else if (TemperatureType.fromValue(sourceTypeValue) != null) {
            type = ConverterType.TEMPERATURE;
        } else if (WeightType.fromValue(sourceTypeValue) != null) {
            type = ConverterType.WEIGHT;
        } else type = ConverterType.UNKNOWN;

        return type;
    }

    private static ConverterType resolveTargetValueType(String targetTypeValue) {
        ConverterType type;
        if (DistanceType.fromValue(targetTypeValue) != null) {
            type = ConverterType.DISTANCE;
        } else if (TemperatureType.fromValue(targetTypeValue) != null) {
            type = ConverterType.TEMPERATURE;
        } else if (WeightType.fromValue(targetTypeValue) != null) {
            type = ConverterType.WEIGHT;
        } else type = ConverterType.UNKNOWN;

        return type;
    }


    private static void validateDTO(RequestDTO dto) {
        ConverterType converterType = getConverterTypeFromValue(dto);
        if (converterType == ConverterType.UNKNOWN) {
            throw new ConversionException(dto);
        }
    }

    private static ConverterType getConverterTypeFromValue(RequestDTO dto) {
        String sourceTypeValue = dto.getSourceType();
        String targetTypeValue = dto.getTargetType();
        ConverterType sourceType = resolveSourceValueType(sourceTypeValue);
        ConverterType targetType = resolveTargetValueType(targetTypeValue);

        if (sourceType == targetType) {
            return sourceType;
        } else {
            return ConverterType.UNKNOWN;
        }
    }


}
