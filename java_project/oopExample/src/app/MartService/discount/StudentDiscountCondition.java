package app.MartService.discount;

import app.MartService.customer.Customer;
import app.MartService.customer.Student;
import app.PhoneInfo;

public class StudentDiscountCondition implements DiscountCondition{
    DiscountPolicy discountPolicy;

    public StudentDiscountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    // 할인 정책을 적용해서 할인값을 리턴하는 메서드
    public int applyDiscountPolicy(int price){
      return discountPolicy.discount(price);
    }

}
