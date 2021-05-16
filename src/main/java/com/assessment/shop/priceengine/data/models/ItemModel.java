package com.assessment.shop.priceengine.data.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name = "items")*/
public class ItemModel {

    @Id
    private String id;
    private String itemName;
    private String unitsPerCarton;
    private String cartonPrice;
    private String lcPercentage;
    private String discountPercentage;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnitsPerCarton() {
        return unitsPerCarton;
    }

    public void setUnitsPerCarton(String unitsPerCarton) {
        this.unitsPerCarton = unitsPerCarton;
    }

    public String getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(String cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public String getLcPercentage() {
        return lcPercentage;
    }

    public void setLcPercentage(String lcPercentage) {
        this.lcPercentage = lcPercentage;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
