package app.MartService.discount;

public class StudentDiscountCondition implements DiscountCondition{
//    RatePolicy ratePolicy;
    DiscountPolicy discountPolicy;

//    public StudentDiscountCondition(RatePolicy ratePolicy) {
//        this.ratePolicy = ratePolicy;
//    }
    public StudentDiscountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    // 할인 정책을 적용해서 할인값을 리턴하는 메서드
//    public int applyDiscountPolicy(int price){
//        return ratePolicy.discount(price);
//    }
    public int applyDiscountPolicy(int price){
      return discountPolicy.discount(price);
    }

}
