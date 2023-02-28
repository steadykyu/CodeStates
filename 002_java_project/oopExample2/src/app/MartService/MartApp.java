package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.CustomerRepository;
import app.MartService.customer.RemovedRepository;
import app.MartService.discount.*;
import app.PhoneInfo;

import java.util.ArrayList;
import java.util.HashMap;


public class MartApp {
    CustomerRepository customerRepository;
    PhoneInfo phoneInfo;
    Discount discountClass;
    RemovedRepository removedRepository;


    public MartApp(CustomerRepository customerRepository, PhoneInfo phoneInfo, Discount discountClass, RemovedRepository removedRepository) {
        this.customerRepository = customerRepository;
        this.phoneInfo = phoneInfo;
        this.discountClass = discountClass;
        this.removedRepository = removedRepository;
    }

    public void start(){
        // 할인 로직 시작
        // -----------인스턴스변수의 초기화순서 : 기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자
        // 그래서 메서드 안에서 지역변수로 선언했다.
        Customer[] customers = customerRepository.findAll();
        int originalPrice = phoneInfo.getPrice();

        MartService martService = new MartService(customers, phoneInfo.getPrice(), discountClass);

        System.out.println("-".repeat(50));
        System.out.println("핸드폰의 원가는 " + phoneInfo.getPrice() + "원 입니다.");
        System.out.println("-".repeat(50));
        martService.service();

        // id == 4 를 가진 한 고객을 지워도록하자.
        customerRepository.removeCustomer(4);
//        customers = customerRepository.findAll();
        customers = removedRepository.getCustomerRepository().findAll();
        martService = new MartService(customers, phoneInfo.getPrice(), discountClass);
        martService.service();
    }
}
