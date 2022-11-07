package extends_class;

public class Child extends Parent{
    int money = 10000;

    public void buyRice(){
        money -= 5000;
        System.out.println("밥을 구입했습니다.");
        System.out.printf("잔액은 %s 입니다", money);
    }

    public void buyWater(){
        money -= 1000;
        System.out.println("물을 구입했습니다.");
        System.out.printf("잔액은 %s 입니다", money);
    }

//    public void buyCar(){
//        money -= 1000000L;
//        System.out.println("차를 구입했습니다.");
//        System.out.printf("잔액은 %s 입니다", money);
//    }
//오버라이딩을 안하면, 상위 클래스의 super.money를 이용하여 buyCar()가 호출된다.

    public static void main(String[] args) {
        Child child = new Child();
        child.buyCar();
        child.buyHouse();
    }
}
