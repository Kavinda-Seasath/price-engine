package com.assessment.shop.priceengine.controller;


import com.assessment.shop.priceengine.data.repositories.ItemRepository;
import com.assessment.shop.priceengine.dto.PriceCalculatorDTO;
import com.assessment.shop.priceengine.dto.PriceCalculatorRequestDTO;
import com.assessment.shop.priceengine.dto.PriceListResponseDTO;
import com.assessment.shop.priceengine.services.PriceEngineService;
import com.assessment.shop.priceengine.services.PriceListGeneratorService;
import com.assessment.shop.priceengine.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
@RequestMapping("v1/api")
public class PriceEndpoint {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/pricelist")
    public PriceListResponseDTO getPriceList(){
        //Get all the prices per units upto 50 units for both items
        PriceListGeneratorService priceListGeneratorService = new PriceListGeneratorService(itemRepository);
        PriceListResponseDTO priceListResponseDTO = priceListGeneratorService.getPriceList();
        return priceListResponseDTO;

    }

    @PostMapping("/calculator")
    public PriceCalculatorDTO getPriceForSelectedUnits(@RequestBody PriceCalculatorRequestDTO priceCalculatorRequestDTO){

        //calculate selected unit prices through price engine
        //validation to check request body data empty or not
        Validations.validateRequest(priceCalculatorRequestDTO);
        PriceEngineService priceEngineService = new PriceEngineService(itemRepository);
        PriceCalculatorDTO priceCalculatorDTO = priceEngineService.getPrice(priceCalculatorRequestDTO.getPenguinUnits(),priceCalculatorRequestDTO.getHorseshoeUnits());
        return priceCalculatorDTO;

    }

}
