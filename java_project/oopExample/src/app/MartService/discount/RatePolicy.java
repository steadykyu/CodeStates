package app.MartService.discount;

public class RatePolicy implements DiscountPolicy{
    private int discountRate;

    public RatePolicy(int discountRate) {
        this.discountRate = discountRate;
    }

    public int discount(int price){
        return price - (price * discountRate / 100);
    }
}
