package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.MartService.discount.AmountPolicy;
import app.MartService.discount.EmployeeDiscountCondition;
import app.MartService.discount.RatePolicy;
import app.MartService.discount.StudentDiscountCondition;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MartService {
    private Customer[] customers;
    int originalPrice;
    // 이걸 배열대신에 Map형식으로 하면, 이름값으로 원하는 할인조건을 적용할수 있을듯하다.
    StudentDiscountCondition studentDiscountCondition = new StudentDiscountCondition(new RatePolicy(10));
    EmployeeDiscountCondition employeeDiscountCondition = new EmployeeDiscountCondition(new AmountPolicy(10000));

    public MartService(Customer[] customers, int originalPrice) {
        this.customers = customers;
        this.originalPrice = originalPrice;
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
                discountedHashMap.put(customer, studentDiscountCondition.applyDiscountPolicy(originalPrice));
            }
            else if(customer instanceof Employee) discountedHashMap.put(customer, employeeDiscountCondition.applyDiscountPolicy(originalPrice));
            else discountedHashMap.put(customer, originalPrice);
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
