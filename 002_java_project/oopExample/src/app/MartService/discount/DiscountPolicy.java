package app.MartService.discount;

public interface DiscountPolicy {
    int discountAmount=0;

    int discount(int price);

}
