package bsu.radkevich.converter.utils;

import bsu.radkevich.converter.converters.ConverterService;
import bsu.radkevich.converter.converters.impl.DistanceConverterServiceImpl;
import bsu.radkevich.converter.converters.impl.TemperatureConverterServiceImpl;
import bsu.radkevich.converter.converters.impl.WeightConverterServiceImpl;
import bsu.radkevich.converter.dto.enums.ConverterType;

public class ConvertersFactory {
    private static ConvertersFactory instance = new ConvertersFactory();

    public ConverterService getConverter(ConverterType converterType) {
        ConverterService converterService;
        switch (converterType) {
            case DISTANCE:
                converterService = DistanceConverterServiceImpl.getInstance();
                break;
            case TEMPERATURE:
                converterService = TemperatureConverterServiceImpl.getInstance();
                break;
            case WEIGHT:
                converterService = WeightConverterServiceImpl.getInstance();
                break;
            case UNKNOWN:
                converterService = null;
                break;
            default:
                converterService = null;
                break;

        }
        return converterService;
    }

    public static ConvertersFactory getInstance() {
        return instance;
    }
}
