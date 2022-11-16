package polymorphism.overrideExample;

public class Main {
    public static void main(String[] args) {
        Customer customer = new VipCustomer();
        customer.calPrice();
        customer.showCustomerInfo();
//        customer.getVipid(); // 컴파일 에러
    }
}
