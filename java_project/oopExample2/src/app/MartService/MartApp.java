package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.CustomerRepository;
import app.MartService.discount.AmountPolicy;
import app.MartService.discount.EmployeeDiscountCondition;
import app.MartService.discount.RatePolicy;
import app.MartService.discount.StudentDiscountCondition;
import app.PhoneInfo;


public class MartApp {

    public void start(){
        // 고객정보
        CustomerRepository customerRepository = new CustomerRepository();
        Customer[] customers = customerRepository.findAll();
        int originalPrice = new PhoneInfo(1000000, "iphone").getPrice();

        MartService martService = new MartService(customers, originalPrice);

        // 할인 로직 시작
        martService.service();
    }

}
