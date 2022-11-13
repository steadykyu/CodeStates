package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.MartService.discount.*;
import app.PhoneInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MartService {
    private Customer[] customers;
    private PhoneInfo phoneInfo;

    int price = phoneInfo.getPrice();
    DiscountCondition discountCondition;

    public MartService(Customer[] customers, PhoneInfo phoneInfo, int price, DiscountCondition discountCondition) {
        this.customers = customers;
        this.phoneInfo = phoneInfo;
        this.discountCondition = discountCondition;
    }

    HashMap<Customer, Integer> discountedHashMap = new HashMap<>();

    // 주요 로직 : 고객마다의 할인 요금을 구해서 출력해주자!!
    public void service(){
        // 각 고객마다 할인을 적용해본다.
        DiscountAllCustomers();

        // 고객마다의 할인 요금 출력하기
        printDiscountedPrice();
    }

    private void DiscountAllCustomers() {
        for(Customer customer : customers){
            if(customer instanceof Student) discountedHashMap.put(customer, discountCondition.applyDiscountPolicy(price));
            else if(customer instanceof Employee) discountedHashMap.put(customer, discountCondition.applyDiscountPolicy(price));
            else discountedHashMap.put(customer, price);
        }
    }

    private void printDiscountedPrice() {
        System.out.println("할인 요금을 출력합니다.");
        Set<Customer> keySet = discountedHashMap.keySet();
        Iterator<Customer> iter = keySet.iterator();
        while(iter.hasNext()){
            Customer customer = iter.next();
            System.out.printf("고객이름 : %s , 할인된요금 : %d\n", customer.getName(), discountedHashMap.get(customer));
        }
    }
}
