package com.assessment.shop.priceengine.services;

import com.assessment.shop.priceengine.dto.PriceCalculatorDTO;

public class PriceEngineService {

    private static int PENGUIN_EARS_CARTON = 175;
    private static int PENGUIN_EARS_UNITS_PER_CARTON = 20;
    private static int HORSESHOE_CARTON = 825;
    private static int HORSESHOE_UNITS_PER_CARTON = 5;
    private static float PER_UNIT_LABOR_COST_PERCENTAGE = 0.3f;
    private static float DISCOUNT_PERCENTAGE = 0.1f;

    public static PriceCalculatorDTO getPrice(String penguinUnits, String horseshoeUnits){
        PriceCalculatorDTO priceCalculatorDTO = new PriceCalculatorDTO();
        double penguinEarCost   = getItemPrice(Long.parseLong(penguinUnits),PENGUIN_EARS_CARTON,PENGUIN_EARS_UNITS_PER_CARTON);
        double horseshoeCost    = getItemPrice(Long.parseLong(horseshoeUnits),HORSESHOE_CARTON,HORSESHOE_UNITS_PER_CARTON);
        double fullPrice = penguinEarCost+horseshoeCost;
        priceCalculatorDTO.setPrice(fullPrice);
        return priceCalculatorDTO;
    }

    public static double getItemPrice(long unitCount, int cartonPrice, int unitsPerCarton){
        long cartons = unitCount/unitsPerCarton;
        long extraUnits = unitCount%unitsPerCarton;
        double cartonCost = cartons>=3? ((cartonPrice-(cartonPrice*DISCOUNT_PERCENTAGE))*cartons) : (cartonPrice*cartons);
        double price = cartonCost + (extraUnits*getSingleUnitPrice(cartonPrice,unitsPerCarton));
        return price;
    }

    private static float getSingleUnitPrice(int cartonPrice, int unitsPerCarton){

        float price = ((cartonPrice*PER_UNIT_LABOR_COST_PERCENTAGE) + cartonPrice)/unitsPerCarton;
        return price;

    }
}
