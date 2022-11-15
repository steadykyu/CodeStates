package app.MartService.discount;

public class EmployeeDiscountCondition {
    AmountPolicy amountPolicy;

    public EmployeeDiscountCondition(AmountPolicy amountPolicy) {
        this.amountPolicy = amountPolicy;
    }

    public int applyDiscountPolicy(int price){
        return amountPolicy.discount(price);
    }

}
