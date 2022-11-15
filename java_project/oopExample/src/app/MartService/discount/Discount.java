package app.MartService.discount;

import java.util.HashMap;
// 캡슐화 및 컬렉션 성공!
public class Discount {
    private HashMap<String, DiscountCondition> discountConditionHashMap;

    public Discount(HashMap<String, DiscountCondition> discountConditionHashMap) {
        this.discountConditionHashMap = discountConditionHashMap;
    }

    public int discount(String customerType, int originalPrice){
        return discountConditionHashMap.get(customerType).applyDiscountPolicy(originalPrice);
    }
}
