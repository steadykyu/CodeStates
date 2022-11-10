package abstraction.interfaceExam;

//카페 손님
class CafeCustomer {
    public String CafeCustomerName;

    public void setCafeCustomerName(String CafeCustomerName) {
        this.CafeCustomerName = CafeCustomerName;
    }
}

interface Customer{
    // 상수
    // 추상 메서드
    public abstract String getOrder();
}

class CafeCustomerA implements Customer {
    public String getOrder(){
        return "a glass of iced americano";
    } // 주문을 반환
}

class CafeCustomerB implements Customer {
    public String getOrder(){
        return "a glass of strawberry latte";
    } // 주문을 반환
}

//카페 사장님
class CafeOwner {
//    public void giveItem(CafeCustomerB cafeCustomerB) {
//        System.out.println("give a glass of strawberry latte to CafeCustomer B");
//    }
//
//    public void giveItem(CafeCustomerA cafeCustomerA) {
//        System.out.println("give a glass of iced americano to CafeCustomer A");
//    }
// 인터페이스를 활용하여 작성한 코드
    public void giveItem(Customer customer) {
        System.out.println("Item : " + customer.getOrder());
    }
}

//메뉴 주문
//public class OrderExample {
//    public static void main(String[] args) throws Exception {
//
//        CafeOwner cafeowner = new CafeOwner();
//        CafeCustomerA a = new CafeCustomerA();
//        CafeCustomerB b = new CafeCustomerB();
//
//        cafeowner.giveItem(a);
//        cafeowner.giveItem(b);
//    }
//}

public class OrderExample {
    public static void main(String[] args) throws Exception {
        CafeOwner cafeowner = new CafeOwner();
        Customer cafeCustomerA = new CafeCustomerA();
        Customer cafeCustomerB = new CafeCustomerB();

        cafeowner.giveItem(cafeCustomerA);
        cafeowner.giveItem(cafeCustomerB);
    }
}
