package com.assessment.shop.priceengine.services;

import com.assessment.shop.priceengine.data.models.ItemModel;
import com.assessment.shop.priceengine.data.repositories.ItemRepository;
import com.assessment.shop.priceengine.dto.PriceListResponseDTO;
import java.util.ArrayList;
import java.util.List;


public class PriceListGeneratorService {

    private int PENGUIN_EARS_CARTON ;
    private int PENGUIN_EARS_UNITS_PER_CARTON;
    private int HORSESHOE_CARTON;
    private int HORSESHOE_UNITS_PER_CARTON;
    private float PER_UNIT_LABOR_COST_PERCENTAGE;
    private float DISCOUNT_PERCENTAGE;

    private ItemRepository itemRepository;

    public PriceListGeneratorService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public PriceListResponseDTO getPriceList(){

        try{
            //fetch item data from  database and populate fields
            ArrayList<ItemModel> data = (ArrayList<ItemModel>) itemRepository.findAll();
            mapData(data);
        } catch (Exception e){
            throw e;
        }

        List<String> penguinList = getPenguinEarsPriceList();
        List<String> horseshoeList = getHorseshoePriceList();
        PriceListResponseDTO priceListResponseDTO = new PriceListResponseDTO();
        priceListResponseDTO.setPenguinEars(penguinList);
        priceListResponseDTO.setHorseShoe(horseshoeList);
        return priceListResponseDTO;
    }



    private List<String> getPenguinEarsPriceList(){
        //calculate penguin ears price list upto 50 units
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

    private List<String> getHorseshoePriceList(){
        //calculate horseshoe price list upto 50 units
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

    private float getSingleUnitPrice(int cartonPrice, int unitsPerCarton){

        //get single unit price depending on labour cost
        float price = ((cartonPrice*PER_UNIT_LABOR_COST_PERCENTAGE) + cartonPrice)/unitsPerCarton;
        return price;

    }

    public void mapData(ArrayList<ItemModel> data){
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
