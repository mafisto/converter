package bsu.radkevich.converter;

import bsu.radkevich.converter.controller.ConverterController;
import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.TemperatureType;
import bsu.radkevich.converter.dto.enums.WeightType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperatureConverterTests {

    @Autowired
    ConverterController controller;


    @Test
    public void testKelvinToCelsiusConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(500);
        requestDTO.setSourceType(TemperatureType.KELVIN.getValue());
        requestDTO.setTargetType(TemperatureType.CELSIUS.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.TEMPERATURE, converterType);
        assertEquals(TemperatureType.CELSIUS.getValue(), valueType);
        assertEquals(226.85, resultValue, 2.0);
    }

    @Test
    public void testCelsiusToKelvinConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(226.85);
        requestDTO.setSourceType(TemperatureType.CELSIUS.getValue());
        requestDTO.setTargetType(TemperatureType.KELVIN.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.TEMPERATURE, converterType);
        assertEquals(TemperatureType.KELVIN.getValue(), valueType);
        assertEquals(500, resultValue, 2.0);
    }

    @Test
    public void testKelvinToFahrenheitConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(443);
        requestDTO.setSourceType(TemperatureType.KELVIN.getValue());
        requestDTO.setTargetType(TemperatureType.FAHRENHEIT.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.TEMPERATURE, converterType);
        assertEquals(TemperatureType.FAHRENHEIT.getValue(), valueType);
        assertEquals(337.73, resultValue, 2.0);
    }

    @Test
    public void testFahrenheitToKelvinConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(337.73);
        requestDTO.setSourceType(TemperatureType.FAHRENHEIT.getValue());
        requestDTO.setTargetType(TemperatureType.KELVIN.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.TEMPERATURE, converterType);
        assertEquals(TemperatureType.KELVIN.getValue(), valueType);
        assertEquals(443, resultValue, 2.0);
    }
    @Test
    public void testCelsiusToFahrenheitConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(127);
        requestDTO.setSourceType(TemperatureType.CELSIUS.getValue());
        requestDTO.setTargetType(TemperatureType.FAHRENHEIT.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.TEMPERATURE, converterType);
        assertEquals(TemperatureType.FAHRENHEIT.getValue(), valueType);
        assertEquals(260.6, resultValue, 2.0);
    }

    @Test
    public void testFahrenheitToCelsiusConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(260.6);
        requestDTO.setSourceType(TemperatureType.FAHRENHEIT.getValue());
        requestDTO.setTargetType(TemperatureType.CELSIUS.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.TEMPERATURE, converterType);
        assertEquals(TemperatureType.CELSIUS.getValue(), valueType);
        assertEquals(127, resultValue, 2.0);
    }

}

