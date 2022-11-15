package app.MartService.discount;

public class AmountPolicy {
    private int discountAmount;

    public AmountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int discount(int price){
        return price - discountAmount;
    }
}
