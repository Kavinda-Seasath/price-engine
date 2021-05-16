package com.assessment.shop.priceengine.controller;


import com.assessment.shop.priceengine.dto.PriceCalculatorDTO;
import com.assessment.shop.priceengine.dto.PriceCalculatorRequestDTO;
import com.assessment.shop.priceengine.dto.PriceListResponseDTO;
import com.assessment.shop.priceengine.services.PriceEngineService;
import com.assessment.shop.priceengine.services.PriceListGeneratorService;
import com.assessment.shop.priceengine.util.Validations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
@RequestMapping("v1/api")
public class PriceEndpoint {

    @GetMapping("/pricelist")
    public PriceListResponseDTO getPriceList(){

        PriceListResponseDTO priceListResponseDTO = PriceListGeneratorService.getPriceList();
        return priceListResponseDTO;

    }

    @PostMapping("/calculator")
    public PriceCalculatorDTO getPriceForSelectedUnits(@RequestBody PriceCalculatorRequestDTO priceCalculatorRequestDTO){

        Validations.validateRequest(priceCalculatorRequestDTO);

        PriceCalculatorDTO priceCalculatorDTO = PriceEngineService.getPrice(priceCalculatorRequestDTO.getPenguinUnits(),priceCalculatorRequestDTO.getHorseshoeUnits());
        return priceCalculatorDTO;

    }

}
