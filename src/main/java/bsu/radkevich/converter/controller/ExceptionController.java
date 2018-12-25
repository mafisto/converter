package bsu.radkevich.converter.controller;

import bsu.radkevich.converter.dto.ExceptionDTO;
import bsu.radkevich.converter.exceptions.ConversionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(ConversionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ExceptionDTO converterErrorHandler (ConversionException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setErrorType("Validation error");
        exceptionDTO.setErrorMessage(ex.getMessage());

        return exceptionDTO;
    }
}
