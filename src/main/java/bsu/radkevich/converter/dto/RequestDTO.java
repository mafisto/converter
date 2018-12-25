package bsu.radkevich.converter.dto;


public class RequestDTO {
    private double value;
    private String sourceType;
    private String targetType;

    public RequestDTO() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getTargetType() {
        return targetType;
    }
}
