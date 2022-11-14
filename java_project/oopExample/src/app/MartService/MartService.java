package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.MartService.discount.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MartService {
    private Customer[] customers;
    int originalprice;
    // 이걸 배열대신에 Map형식으로 하면, 이름값으로 원하는 할인조건을 적용할수 있을듯하다.
    DiscountCondition[] discountConditions;

    public MartService(Customer[] customers, int originalprice, DiscountCondition[] discountConditions) {
        this.customers = customers;
        this.originalprice = originalprice;
        this.discountConditions = discountConditions;
    }

    HashMap<Customer, Integer> discountedHashMap = new HashMap<>();

    // 주요 로직 : 고객마다의 할인 요금을 구해서 출력해주자!!
    public void service(){
        // 각 고객마다 할인을 적용해본다.
        DiscountAllCustomers();

        // 고객마다의 할인 요금 출력하기
        printDiscountedPrice();
    }

    // discountConditions 이거가지고 수정

    private void DiscountAllCustomers() {
        for(Customer customer : customers){
            if(customer instanceof Student) {
                discountedHashMap.put(customer, discountConditions[0].applyDiscountPolicy(originalprice));
            }
            else if(customer instanceof Employee) discountedHashMap.put(customer, discountConditions[1].applyDiscountPolicy(originalprice));
            else discountedHashMap.put(customer, originalprice);
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
