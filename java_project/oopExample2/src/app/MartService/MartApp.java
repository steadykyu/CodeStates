package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.CustomerRepository;
import app.MartService.customer.RemovedRepository;
import app.MartService.discount.*;
import app.PhoneInfo;

import java.util.ArrayList;
import java.util.HashMap;


public class MartApp {
    // 주입이 필요한 객체들-------------------
    CustomerRepository customerRepository;
    PhoneInfo phoneInfo;
    Discount discountClass;
    RemovedRepository removedRepository;
    //-------------------------------------


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
        int id = 4;
        System.out.println("-".repeat(50));
        System.out.println(id + "번 id를 가진 고객을 지웠습니다.");
        System.out.println("-".repeat(50));
        customerRepository.removeCustomer(4);
        // removedRepository에 저장된 db를 가져오자.
        // 사실 customer 에서 꺼내오면 되지만.. 싱글톤 패턴을 보기위해 removedRepository 참조변수에서 DB를 가져오자.
        // remove가 되지 않은 원본 Repository가 나오고 있다. 싱글톤으로 고쳐주자.
        customers = removedRepository.getCustomerRepository().findAll();
        martService = new MartService(customers, phoneInfo.getPrice(), discountClass);
        martService.service();
    }
}
