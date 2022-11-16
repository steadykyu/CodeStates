package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.CustomerRepository;
import app.MartService.discount.*;
import app.PhoneInfo;

import java.util.ArrayList;
import java.util.HashMap;


public class MartApp {
    // 고객정보
    CustomerRepository customerRepository = new CustomerRepository();
    Customer[] customers = customerRepository.findAll();
    int originalPrice = new PhoneInfo(1000000, "iphone").getPrice();
    // ------------ 추가
    HashMap<String, DiscountCondition> discountConditionHashMap = new HashMap<String, DiscountCondition>(){{
        put("학생",new StudentDiscountCondition(new RatePolicy(10)));
        put("직원",new EmployeeDiscountCondition(new AmountPolicy(10000)));
    }};
    // ----------------
    MartService martService
            = new MartService(customers, originalPrice, discountConditionHashMap);



    public void start(){
        // 할인 로직 시작
        martService.service();
    }
}
