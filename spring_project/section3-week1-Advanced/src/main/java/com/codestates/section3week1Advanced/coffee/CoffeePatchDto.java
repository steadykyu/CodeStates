package com.codestates.section3week1Advanced.coffee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeePatchDto {
    private long coffeeId;
    private String korName;
    private int price;

    public CoffeePatchDto(long coffeeId, String korName, int price) {
        this.coffeeId = coffeeId;
        this.korName = korName;
        this.price = price;
    }
}
