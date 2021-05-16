package com.assessment.shop.priceengine.services;

import com.assessment.shop.priceengine.dto.PriceListResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class PriceListGeneratorService {

    private static int PENGUIN_EARS_CARTON = 175;
    private static int PENGUIN_EARS_UNITS_PER_CARTON = 20;
    private static int HORSESHOE_CARTON = 825;
    private static int HORSESHOE_UNITS_PER_CARTON = 5;
    private static float PER_UNIT_LABOR_COST_PERCENTAGE = 0.3f;
    private static float DISCOUNT_PERCENTAGE = 0.1f;

    List<String> priceList;

    public static PriceListResponseDTO getPriceList(){
        List<String> penguinList = getPenguinEarsPriceList();
        List<String> horseshoeList = getHorseshoePriceList();
        PriceListResponseDTO priceListResponseDTO = new PriceListResponseDTO();
        priceListResponseDTO.setPenguinEars(penguinList);
        priceListResponseDTO.setHorseShoe(horseshoeList);
        return priceListResponseDTO;
    }



    private static List<String> getPenguinEarsPriceList(){
        List<String> penguinPriceList = new ArrayList<>();
        for (int i=1;i<=50;i++){
            int cartons = i/PENGUIN_EARS_UNITS_PER_CARTON;
            int unitsLeft = i%PENGUIN_EARS_UNITS_PER_CARTON;
            float cartonPrice = cartons>=3? ((PENGUIN_EARS_CARTON-(PENGUIN_EARS_CARTON*DISCOUNT_PERCENTAGE))*cartons) : (PENGUIN_EARS_CARTON*cartons);
            float price = cartonPrice + (getSingleUnitPrice(PENGUIN_EARS_CARTON,PENGUIN_EARS_UNITS_PER_CARTON)*unitsLeft);
            penguinPriceList.add(String.valueOf(price));
        }
        return penguinPriceList;
    }

    private static List<String> getHorseshoePriceList(){
        List<String> horseshoePriceList = new ArrayList<>();
        for (int i=1;i<=50;i++){
            int cartons = i/HORSESHOE_UNITS_PER_CARTON;
            int unitsLeft = i%HORSESHOE_UNITS_PER_CARTON;
            float cartonPrice = cartons>=3? ((HORSESHOE_CARTON-(HORSESHOE_CARTON*DISCOUNT_PERCENTAGE))*cartons) : (HORSESHOE_CARTON*cartons);
            float price = cartonPrice + (getSingleUnitPrice(HORSESHOE_CARTON,HORSESHOE_UNITS_PER_CARTON)*unitsLeft);
            horseshoePriceList.add(String.valueOf(price));
        }
        return horseshoePriceList;
    }

    private static float getSingleUnitPrice(int cartonPrice, int unitsPerCarton){

        float price = ((cartonPrice*PER_UNIT_LABOR_COST_PERCENTAGE) + cartonPrice)/unitsPerCarton;
        return price;

    }
}
