package bsu.radkevich.converter.converters;

import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;

public interface ConverterService {
    ResponseDTO convert (RequestDTO dto);
}
