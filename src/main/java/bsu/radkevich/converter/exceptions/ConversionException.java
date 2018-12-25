package bsu.radkevich.converter.exceptions;

import bsu.radkevich.converter.dto.RequestDTO;

public class ConversionException extends RuntimeException {
    public ConversionException(RequestDTO dto) {
        super("Conversion error: source type - " + dto.getSourceType() + " and target type - " + dto.getTargetType() + " dont belong to the same converter type");
    }
}
