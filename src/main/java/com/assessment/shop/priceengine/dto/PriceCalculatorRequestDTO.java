package com.assessment.shop.priceengine.dto;

import java.io.Serializable;

public class PriceCalculatorRequestDTO implements Serializable {

    private String penguinUnits;
    private String horseshoeUnits;

    public String getPenguinUnits() {
        return penguinUnits;
    }

    public void setPenguinUnits(String penguinUnits) {
        this.penguinUnits = penguinUnits;
    }

    public String getHorseshoeUnits() {
        return horseshoeUnits;
    }

    public void setHorseshoeUnits(String horseshoeUnits) {
        this.horseshoeUnits = horseshoeUnits;
    }
}
