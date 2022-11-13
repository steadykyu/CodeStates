package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.CustomerRepository;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.PhoneInfo;


public class MartApp {

    public void start(){
        // 고객정보
        CustomerRepository customerRepository = new CustomerRepository();
        Customer[] customers = customerRepository.findAll();
        PhoneInfo phoneInfo = new PhoneInfo(1000000, "iphone");
        MartService martService = new MartService(customers, phoneInfo,);
        // 지금 나는 두개의 정책이 필요하니까, 배열로 주입해야할듯하다.!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //    StudentDiscountCondition studentDiscountPolicy = new StudentDiscountCondition(new RatePolicy(10));
//    EmployeeDiscountCondition employeeDiscountCondition = new EmployeeDiscountCondition(new AmountPolicy(10000));

        // 할인 로직 시작
        martService.service();
    }

}
