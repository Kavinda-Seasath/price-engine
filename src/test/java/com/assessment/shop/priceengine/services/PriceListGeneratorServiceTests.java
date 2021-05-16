package com.assessment.shop.priceengine.services;

import com.assessment.shop.priceengine.PriceEngineApplicationTests;
import com.assessment.shop.priceengine.dto.PriceListResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PriceListGeneratorServiceTests extends PriceEngineApplicationTests {

    private PriceListGeneratorService priceListGeneratorService;


    @Test
    public void getPriceListShouldReturnArray(){
        PriceListResponseDTO priceListResponseDTO = priceListGeneratorService.getPriceList();
        Assertions.assertTrue(!priceListResponseDTO.getHorseShoe().isEmpty());
        Assertions.assertTrue(!priceListResponseDTO.getPenguinEars().isEmpty());
    }
}
