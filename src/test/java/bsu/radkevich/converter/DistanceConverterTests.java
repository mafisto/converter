package bsu.radkevich.converter;

import bsu.radkevich.converter.controller.ConverterController;
import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.DistanceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistanceConverterTests {

    @Autowired
    ConverterController controller;



    @Test
    public void testMetresToMilesConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(516599);
        requestDTO.setSourceType(DistanceType.METRES.getValue());
        requestDTO.setTargetType(DistanceType.MILES.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.DISTANCE, converterType);
        assertEquals(DistanceType.MILES.getValue(), valueType);
        assertEquals(321 , resultValue, 2.0);
    }

    @Test
    public void testMilesToMetresConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(321);
        requestDTO.setSourceType(DistanceType.MILES.getValue());
        requestDTO.setTargetType(DistanceType.METRES.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.DISTANCE, converterType);
        assertEquals(DistanceType.METRES.getValue(), valueType);
        assertEquals(516599 , resultValue, 2.0);
    }

}

