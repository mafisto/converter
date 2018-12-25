package bsu.radkevich.converter.converters;

import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.exceptions.ConversionException;
import bsu.radkevich.converter.utils.ConverterUtils;
import bsu.radkevich.converter.utils.ConvertersFactory;

public class MainConverter {
    public static ResponseDTO convert(RequestDTO dto) throws ConversionException {
        ConverterType converterType = ConverterUtils.resolveConverterType(dto);
        ConvertersFactory convertersFactory = ConvertersFactory.getInstance();
        ConverterService converter = convertersFactory.getConverter(converterType);
        ResponseDTO convertedValue = converter.convert(dto);
        return convertedValue;
    }


}
