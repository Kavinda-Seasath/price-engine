package com.assessment.shop.priceengine.dto;

public class PriceCalculatorDTO {

    private double price;

    public PriceCalculatorDTO() {
    }

    public PriceCalculatorDTO(float price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
