package app.tax_service;

import app.MartService.customer.Customer;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.PhoneInfo;

import java.util.ArrayList;

//TaxService는 MartService와 전혀 관련 없는 서비스이다.
// 다만, Phone의 할인가를 가지고 세금을 매긴다고 하자.
public class TaxService {
    ArrayList<Integer> taxList = new ArrayList<>();
    public void taxService(){
        System.out.println("-".repeat(100));
        System.out.println("지금부터는 세금 서비스 로직입니다.");

        Customer[] customers = new Customer[]{
                new Customer(1, "김무개","일반"),
                new Student(2, "최학생", "학생","한국고등학교"),
                new Employee(3, "이직원", "직원","코리아마트")
        };

        PhoneInfo phoneInfo = new PhoneInfo(1000000, "Iphone");

        for(Customer customer : customers){
            if(customer instanceof Student)  taxList.add(phoneInfo.getPrice() * 90 / 100);
            else if(customer instanceof Employee) taxList.add(phoneInfo.getPrice() * 80 / 100);
            else taxList.add(phoneInfo.getPrice());
        }

        System.out.println(taxList);
        System.out.println(".".repeat(5));
    }
}
