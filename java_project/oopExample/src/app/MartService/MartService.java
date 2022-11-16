package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.MartService.discount.*;

import java.util.*;

public class MartService {
    private Customer[] customers;
    int originalPrice;
    // 이걸 배열대신에 Map형식으로 하면, 이름값으로 원하는 할인조건을 적용할수 있을듯하다.
    Discount discount;

    public MartService(Customer[] customers, int originalPrice, Discount discount) {
        this.customers = customers;
        this.originalPrice = originalPrice;
        this.discount = discount;
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
            if(customer.getCustomerType() == "일반") discountedHashMap.put(customer, originalPrice);
            else{
                String customerType = customer.getCustomerType();
                discountedHashMap.put(customer, discount.discount(customerType,originalPrice)); // 캡슐화 적용
            }
        }
    }

    private void printDiscountedPrice() {
        System.out.println("할인 요금을 출력합니다.");
        Set<Customer> keySet = discountedHashMap.keySet();
        ArrayList<Customer> al = new ArrayList<>(keySet);
        Collections.sort(al);
        Iterator<Customer> iter = al.iterator();
        while(iter.hasNext()){
            Customer customer = iter.next();
            System.out.printf("고객이름 : %s , 할인된요금 : %d\n", customer.getName(), discountedHashMap.get(customer));
        }
    }
}
