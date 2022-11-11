package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.CustomerRepository;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.PhoneInfo;


public class MartService {

    public void service(){
        // 고객정보
        CustomerRepository customerRepository = new CustomerRepository();
        Customer[] customers = customerRepository.findAll();

        // 핸드폰 가격은 백만원이다.
        PhoneInfo phoneInfo = new PhoneInfo(1000000,"Iphone");

        // 각 고객마다 할인받을시, 얼마에 아이폰을 살수 있을까?
        for(Customer customer : customers){
            if(customer instanceof Student)  customer.setDiscountedPrice(phoneInfo.getPrice() * 90 / 100);
            else if(customer instanceof Employee) customer.setDiscountedPrice(phoneInfo.getPrice() * 80 / 100);
            else customer.setDiscountedPrice(phoneInfo.getPrice());
        }

        //마트에서 50000원 할인 쿠폰을 준다고 하자.



        // 고객정보 및 할인 받는 가격 출력
        for(Customer customer : customers){
            System.out.println(customer);
        }
    }

}
