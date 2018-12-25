package bsu.radkevich.converter.controller;

import bsu.radkevich.converter.converters.MainConverter;
import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {
    private final static String CONVERTER_PATH = "/converter";


    @PostMapping(value = CONVERTER_PATH, consumes ="application/json", produces = "application/json")
    public ResponseDTO convert(@RequestBody RequestDTO requestDTO) {
        ResponseDTO responseDTO = MainConverter.convert(requestDTO);
        return responseDTO;
    }
}
