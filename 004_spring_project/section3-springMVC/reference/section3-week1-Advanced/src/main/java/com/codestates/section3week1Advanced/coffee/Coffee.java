package com.codestates.section3week1Advanced.coffee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coffee {
    private String korName;
    private String engName;
    private int price;

    public Coffee(String korName, String engName, int price) {
        this.korName = korName;
        this.engName = engName;
        this.price = price;
    }
}
