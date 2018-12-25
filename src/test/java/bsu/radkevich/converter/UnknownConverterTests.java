package bsu.radkevich.converter;

import bsu.radkevich.converter.controller.ConverterController;
import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.DistanceType;
import bsu.radkevich.converter.dto.enums.TemperatureType;
import bsu.radkevich.converter.dto.enums.WeightType;
import bsu.radkevich.converter.exceptions.ConversionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnknownConverterTests {

    @Autowired
    ConverterController controller;

    @Test(expected = ConversionException.class)
    public void testUnknownConverter1() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(516599);
        requestDTO.setSourceType(DistanceType.METRES.getValue());
        requestDTO.setTargetType(WeightType.POUNDS.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertNull(converterType);
        assertNull( valueType);
        assertEquals(0, resultValue, 2.0);
    }

    @Test(expected = ConversionException.class)
    public void testUnknownConverter2() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(516599);
        requestDTO.setSourceType(TemperatureType.KELVIN.getValue());
        requestDTO.setTargetType(WeightType.POUNDS.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertNull(converterType);
        assertNull( valueType);
        assertEquals(0, resultValue, 2.0);
    }
    @Test(expected = ConversionException.class)
    public void testUnknownConverter3() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(516599);
        requestDTO.setSourceType(DistanceType.METRES.getValue());
        requestDTO.setTargetType(TemperatureType.CELSIUS.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertNull(converterType);
        assertNull( valueType);
        assertEquals(0, resultValue, 2.0);
    }



}

