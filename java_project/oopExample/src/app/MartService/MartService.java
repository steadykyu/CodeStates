package app.MartService;

import app.MartService.customer.Customer;
import app.MartService.customer.Employee;
import app.MartService.customer.Student;
import app.Phone;


public class MartService {

    public void service(){
        // 아래와 같은 고객이 있다고 하자.
        Customer[] customers = new Customer[]{
                new Customer(1, "김무개"),
                new Student(2, "최학생", "한국고등학교"),
                new Employee(3, "이직원", "코리아마트")
        };
        // 핸드폰 가격은 백만원이다.
        Phone phone = new Phone(1000000,"Iphone");

        // 각 고객마다 할인받을시, 얼마에 아이폰을 살수 있을까?
        for(Customer customer : customers){
            if(customer instanceof Student)  customer.setDiscountedPrice(phone.getPrice() * 90 / 100);
            else if(customer instanceof Employee) customer.setDiscountedPrice(phone.getPrice() * 80 / 100);
            else customer.setDiscountedPrice(phone.getPrice());
        }

        //마트에서 50000원 할인 쿠폰을 준다고 하자.



        // 고객정보 및 할인 받는 가격 출력
        for(Customer customer : customers){
            System.out.println(customer);
        }
    }

}
