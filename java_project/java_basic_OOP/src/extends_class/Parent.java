package extends_class;

public class Parent {
    long money = 1000000000L;

    public void buyCar(){
        money -= 1000000L;
        System.out.println("차를 구입했습니다.");
        System.out.printf("잔액은 %s 입니다", money);
    }

    public void buyHouse(){
        money -= 10000000L;
        System.out.println("집을 구입했습니다.");
        System.out.printf("잔액은 %s 입니다", money);
    }
}
