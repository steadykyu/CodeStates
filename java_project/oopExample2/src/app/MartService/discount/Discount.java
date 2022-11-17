package app.MartService.discount;

import java.util.HashMap;

public class Discount {
    private HashMap<String, DiscountCondition> discountConditionHashMap;

    public Discount(HashMap<String, DiscountCondition> discountConditionHashMap) {
        this.discountConditionHashMap = discountConditionHashMap;
    }

    public int discount(String key, int originalPrice){
        return discountConditionHashMap.get(key).applyDiscountPolicy(originalPrice);
    }
}
