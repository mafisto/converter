package bsu.radkevich.converter;

import bsu.radkevich.converter.controller.ConverterController;
import bsu.radkevich.converter.dto.RequestDTO;
import bsu.radkevich.converter.dto.ResponseDTO;
import bsu.radkevich.converter.dto.enums.ConverterType;
import bsu.radkevich.converter.dto.enums.WeightType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeightConverterTests {

    @Autowired
    ConverterController controller;


    @Test
    public void testGramsToPoundsConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(251290);
        requestDTO.setSourceType(WeightType.GRAMS.getValue());
        requestDTO.setTargetType(WeightType.POUNDS.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.WEIGHT, converterType);
        assertEquals(WeightType.POUNDS.getValue(), valueType);
        assertEquals(554, resultValue, 2.0);
    }

    @Test
    public void testPoundsToGramsConverter() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setValue(554);
        requestDTO.setSourceType(WeightType.POUNDS.getValue());
        requestDTO.setTargetType(WeightType.GRAMS.getValue());
        ResponseDTO response = controller.convert(requestDTO);

        ConverterType converterType = response.getConverterType();
        double resultValue = response.getResultValue();
        String valueType = response.getValueType();

        assertEquals(ConverterType.WEIGHT, converterType);
        assertEquals(WeightType.GRAMS.getValue(), valueType);
        assertEquals(251290, resultValue, 2.0);
    }

}

