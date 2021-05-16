package com.assessment.shop.priceengine.util;

import com.assessment.shop.priceengine.dto.PriceCalculatorRequestDTO;

public class Validations {

    public static void validateRequest(PriceCalculatorRequestDTO priceCalculatorRequestDTO){
        if (priceCalculatorRequestDTO.getPenguinUnits().isEmpty() || priceCalculatorRequestDTO.getPenguinUnits() == null){
            priceCalculatorRequestDTO.setPenguinUnits("0");
        }
        if (priceCalculatorRequestDTO.getHorseshoeUnits().isEmpty() || priceCalculatorRequestDTO.getHorseshoeUnits() == null){
            priceCalculatorRequestDTO.setHorseshoeUnits("0");
        }
    }

}
