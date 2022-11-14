package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.CustomerRepository;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.MartService.discount.*;
import app.PhoneInfo;


public class MartApp {

    public void start(){
        // 고객정보
        CustomerRepository customerRepository = new CustomerRepository();
        Customer[] customers = customerRepository.findAll();
        int originalPrice = new PhoneInfo(1000000, "iphone").getPrice();

        MartService martService = new MartService(customers, originalPrice,
                new DiscountCondition[]{
                        new StudentDiscountCondition(new RatePolicy(10)),
                        new EmployeeDiscountCondition(new AmountPolicy(10000))
                }
        );

        // 할인 로직 시작
        martService.service();
    }

}
