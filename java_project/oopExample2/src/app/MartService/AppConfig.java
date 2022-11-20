package app.MartService;

import app.MartService.customer.CustomerRepository;
import app.MartService.customer.RemovedRepository;
import app.MartService.discount.*;
import app.PhoneInfo;

import java.util.HashMap;

public class AppConfig {
//    private CustomerRepository customerRepository = new CustomerRepository();
//    public CustomerRepository customerRepository(){
//        return customerRepository;
//    }
    public CustomerRepository customerRepository(){
        return new CustomerRepository();
    }

    public PhoneInfo phoneInfo(){
        return new PhoneInfo(1000000, "iphone");
    }

    public Discount discount(){
        return new Discount(new HashMap<String, DiscountCondition>(){{
            put("학생",new StudentDiscountCondition(new RatePolicy(10)));
            put("직원",new EmployeeDiscountCondition(new AmountPolicy(10000)));
        }});
    }

    public RemovedRepository removedRepository(){
        return new RemovedRepository(customerRepository());
    }
}
