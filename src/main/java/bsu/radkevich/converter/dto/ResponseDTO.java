package bsu.radkevich.converter.dto;

import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.DistanceType;

public class ResponseDTO {
    private ConverterType converterType;
    private double resultValue;
    private String  valueType;

    public void setConverterType(ConverterType converterType) {
        this.converterType = converterType;
    }

    public void setResultValue(double resultValue) {
        this.resultValue = resultValue;
    }

    public ConverterType getConverterType() {
        return converterType;
    }

    public double getResultValue() {
        return resultValue;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValueType() {
        return valueType;
    }
}
