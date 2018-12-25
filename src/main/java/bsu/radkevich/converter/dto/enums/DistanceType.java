package bsu.radkevich.converter.dto.enums;

public enum DistanceType {
    METRES("METRES"), MILES("MILES");
    String value;

    DistanceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DistanceType fromValue(String value) {
        for (DistanceType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }

        return null;
    }
}
