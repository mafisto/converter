package bsu.radkevich.converter.dto.enums;

public enum WeightType {
    GRAMS("GRAMS"),  POUNDS("POUNDS");

    String value;

    WeightType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static WeightType fromValue(String value) {
        for (WeightType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }

        return null;
    }
}
