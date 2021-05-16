package com.assessment.shop.priceengine.data.models;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class ItemModel {

    @Id
    @GeneratedValue
    private Integer id;

    private String itemName;
    private String unitsPerCarton;
    private String cartonPrice;
    private String lcPercentage;
    private String discountPercentage;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
