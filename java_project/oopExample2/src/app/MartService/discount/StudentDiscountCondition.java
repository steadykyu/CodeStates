package app.MartService.discount;

public class StudentDiscountCondition {
    RatePolicy ratePolicy;

    public StudentDiscountCondition(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    // 할인 정책을 적용해서 할인값을 리턴하는 메서드
    public int applyDiscountPolicy(int price){
      return ratePolicy.discount(price);
    }

}
