package app.MartService.discount;

public class EmployeeDiscountCondition implements DiscountCondition{
//    AmountPolicy amountPolicy;
    DiscountPolicy discountPolicy;

    public EmployeeDiscountCondition(DiscountPolicy  discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public int applyDiscountPolicy(int price){
        return discountPolicy.discount(price);
    }

}
