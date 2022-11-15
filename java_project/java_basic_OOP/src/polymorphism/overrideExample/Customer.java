package polymorphism.overrideExample;

class Customer {
    void calPrice(){
        System.out.println("상위클래스에서 계산한 가격입니다.");
    }

    void showCustomerInfo(){
        System.out.println("상위클래스에서 실행된 고객 정보 입니다.");
    }
}
