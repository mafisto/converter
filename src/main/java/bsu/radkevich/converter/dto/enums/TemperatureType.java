package bsu.radkevich.converter.dto.enums;

public enum TemperatureType {
    CELSIUS("CELSIUS"),
    FAHRENHEIT("FAHRENHEIT"),
    KELVIN("KELVIN");

    String value;

    TemperatureType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TemperatureType fromValue(String value) {
        for (TemperatureType type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }

        return null;
    }
}
