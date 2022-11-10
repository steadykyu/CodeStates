package polymorphism;

public class PolymorphismEx {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Americano americano = new Americano();
        CaffeLatte caffeLatte = new CaffeLatte();
        customer.buyCoffee(americano);
        customer.buyCoffee(caffeLatte);

        System.out.println("현재 잔액은 " + customer.money + "원 입니다.");
    }
}


class Coffee {
    int price;

    public Coffee(int price) {
        this.price = price;
    }
}

class Americano extends Coffee{
    public Americano(){
        super(4000); // 상위 클래스 Coffee의 생성자를 호출
    }

    public String toString() {return "아메리카노";}; //Object클래스 toString()메서드 오버라이딩
};
class CaffeLatte extends Coffee{
    public CaffeLatte(){
        super(5000);
    }
    public String toString() {return "카페라떼";};
};

class Customer{
    int money = 50000;

//    void buyCoffee(Americano americano){
//        money = money - americano.price;
//    }
//
//    void buyCoffee(CaffeLatte caffeLatte){
//        money = money - caffeLatte.price;
//    }

    // 다형성을 적용
        void buyCoffee(Coffee coffee){
            if(money < coffee.price) { // 물견 가격보다 돈이 없는 경우
                System.out.println("잔액이 부족합니다.");
                return;
            }
            money = money - coffee.price; // 가진돈 - 커피 가격
            System.out.println(coffee + "를 구입했습니다.");
    }

}