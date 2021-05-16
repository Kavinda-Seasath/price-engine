package com.assessment.shop.priceengine.dto;

import java.util.ArrayList;
import java.util.List;

public class PriceListResponseDTO {

    private List<String> penguinEars;
    private List<String> horseShoe;

    public PriceListResponseDTO() {
    }

    public PriceListResponseDTO(List<String> penguinEars, List<String> horseShoe) {
        this.penguinEars = penguinEars;
        this.horseShoe = horseShoe;
    }

    public List<String> getPenguinEars() {
        return penguinEars;
    }

    public void setPenguinEars(List<String> penguinEars) {
        this.penguinEars = penguinEars;
    }

    public List<String> getHorseShoe() {
        return horseShoe;
    }

    public void setHorseShoe(List<String> horseShoe) {
        this.horseShoe = horseShoe;
    }
}
