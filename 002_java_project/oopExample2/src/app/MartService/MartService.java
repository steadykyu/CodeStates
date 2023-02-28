package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.MartService.discount.*;

import java.util.*;

public class MartService {
    private Customer[] customers;
    int originalPrice;
    Discount discountClass;
    private HashMap<Customer, Integer> discountedHashMap = new HashMap<>();
    public MartService(Customer[] customers, int originalPrice
            , Discount discountClass) {
        this.customers = customers;
        this.originalPrice = originalPrice;
        this.discountClass = discountClass;
    }


    // 주요 로직 : 고객마다의 할인 요금을 구해서 출력해주자!!
    public void service(){
        // 각 고객마다 할인을 적용해본다.
        DiscountAllCustomers();

        // 고객마다의 할인 요금 출력하기
        printDiscountedPrice();

    }

    private void DiscountAllCustomers() {
        for(Customer customer : customers){
            String customerType = customer.getCustomerType();
            if(customerType == "일반") discountedHashMap.put(customer, originalPrice);
            else {
                discountedHashMap.put(customer,
                        discountClass.discount(customerType, originalPrice));
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
