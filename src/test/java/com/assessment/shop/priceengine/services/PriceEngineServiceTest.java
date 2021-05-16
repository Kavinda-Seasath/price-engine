package com.assessment.shop.priceengine.services;

import com.assessment.shop.priceengine.PriceEngineApplicationTests;
import com.assessment.shop.priceengine.dto.PriceCalculatorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriceEngineServiceTest extends PriceEngineApplicationTests {


    private PriceEngineService priceEngineService;



    @Test
    public void getPriceShouldReturnValue(){
        String penguinEars = "15";
        String horseshoes = "20";
        PriceCalculatorDTO priceCalculatorDTO = priceEngineService.getPrice(penguinEars,horseshoes);
        Assertions.assertEquals(3140.625, priceCalculatorDTO.getPrice());
    }

    @Test
    public void getItemPriceShouldReturnValue(){
        long unitCount = 10;
        int cartonPrice = 175;
        int unitsPerCarton = 20;
        double returnValue = priceEngineService.getItemPrice(unitCount,cartonPrice,unitsPerCarton);
        Assertions.assertEquals(113.75,returnValue);
    }


}
