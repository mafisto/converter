package bsu.radkevich.converter.dto;

public class ConvertDTO<T> {
    private Double value;
    private T sourceType;
    private T targetType;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public T getSourceType() {
        return sourceType;
    }

    public void setSourceType(T sourceType) {
        this.sourceType = sourceType;
    }

    public T getTargetType() {
        return targetType;
    }

    public void setTargetType(T targetType) {
        this.targetType = targetType;
    }
}
