package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.CustomerRepository;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.MartService.discount.*;
import app.PhoneInfo;

import java.util.HashMap;


public class MartApp {

    public void start(){
        // 고객정보
        CustomerRepository customerRepository = new CustomerRepository();
        Customer[] customers = customerRepository.findAll();
        int originalPrice = new PhoneInfo(1000000, "iphone").getPrice();
        Discount discount = new Discount(new HashMap<String, DiscountCondition>(){{
            put("학생",new StudentDiscountCondition(new RatePolicy(10)));
            put("직원",new EmployeeDiscountCondition(new AmountPolicy(10000)));
            //put("유아", new EmployeeDiscountCondition(new RatePolicy(30)));
        }});

        MartService martService = new MartService(customers, originalPrice,discount);

        // 할인 로직 시작
        martService.service();
    }

}
