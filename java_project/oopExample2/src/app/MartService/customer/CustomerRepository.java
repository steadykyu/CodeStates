package app.MartService.customer;

public class CustomerRepository {
    // 아래와 같이 총 세명의 고객이 존재한다고 하자.
    private Customer[] customers = new Customer[]{
            new Customer(1, "김무개","일반"),
            new Student(2, "최학생", "학생", "한국고등학교"),
            new Employee(3, "이직원", "직원", "대한마트"),
            new Employee(4, "박직원", "직원", "대한마트")
    };

    public Customer[] findAll(){
        return customers;
    }

    public void removeCustomer(int id){
       Customer[] newcustomers = new Customer[customers.length-1];
       System.arraycopy(customers,0,newcustomers,0,id-1);
       System.arraycopy(customers,id,newcustomers,id-1,customers.length - id);
       customers = newcustomers;
    }
}
