package com.assessment.shop.priceengine.services;

import com.assessment.shop.priceengine.data.models.ItemModel;
import com.assessment.shop.priceengine.data.repositories.ItemRepository;
import com.assessment.shop.priceengine.dto.PriceCalculatorDTO;

import java.util.ArrayList;

public class PriceEngineService {

    private int PENGUIN_EARS_CARTON;
    private int PENGUIN_EARS_UNITS_PER_CARTON;
    private int HORSESHOE_CARTON;
    private int HORSESHOE_UNITS_PER_CARTON;
    private float PER_UNIT_LABOR_COST_PERCENTAGE;
    private float DISCOUNT_PERCENTAGE ;

    private ItemRepository itemRepository;

    public PriceEngineService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public PriceCalculatorDTO getPrice(String penguinUnits, String horseshoeUnits){

        try{
            //fetch item data from  database and populate fields
            ArrayList<ItemModel> data = (ArrayList<ItemModel>) itemRepository.findAll();
            mapData(data);
        } catch (Exception e){
            throw e;
        }

        PriceCalculatorDTO priceCalculatorDTO = new PriceCalculatorDTO();
        double penguinEarCost   = getItemPrice(Long.parseLong(penguinUnits),PENGUIN_EARS_CARTON,PENGUIN_EARS_UNITS_PER_CARTON);
        double horseshoeCost    = getItemPrice(Long.parseLong(horseshoeUnits),HORSESHOE_CARTON,HORSESHOE_UNITS_PER_CARTON);
        double fullPrice = penguinEarCost+horseshoeCost;
        priceCalculatorDTO.setPrice(fullPrice);
        return priceCalculatorDTO;
    }

    public double getItemPrice(long unitCount, int cartonPrice, int unitsPerCarton){
        //calculate prices for each item depending on discounts and labour cost
        long cartons = unitCount/unitsPerCarton;
        long extraUnits = unitCount%unitsPerCarton;
        double cartonCost = cartons>=3? ((cartonPrice-(cartonPrice*DISCOUNT_PERCENTAGE))*cartons) : (cartonPrice*cartons);
        double price = cartonCost + (extraUnits*getSingleUnitPrice(cartonPrice,unitsPerCarton));
        return price;
    }

    private float getSingleUnitPrice(int cartonPrice, int unitsPerCarton){

        float price = ((cartonPrice*PER_UNIT_LABOR_COST_PERCENTAGE) + cartonPrice)/unitsPerCarton;
        return price;

    }

    public void mapData(ArrayList<ItemModel> data){
        //map data to fields
        for (ItemModel item: data) {
            if (item.getId() == 1){
                this.PENGUIN_EARS_CARTON = Integer.parseInt(item.getCartonPrice());
                this.PENGUIN_EARS_UNITS_PER_CARTON = Integer.parseInt(item.getUnitsPerCarton());
                this.PER_UNIT_LABOR_COST_PERCENTAGE = Float.parseFloat(item.getLcPercentage());
                this.DISCOUNT_PERCENTAGE = Float.parseFloat(item.getDiscountPercentage());
            } else if (item.getId() == 2){
                this.HORSESHOE_CARTON = Integer.parseInt(item.getCartonPrice());
                this.HORSESHOE_UNITS_PER_CARTON = Integer.parseInt(item.getUnitsPerCarton());
            }
        }
    }
}
