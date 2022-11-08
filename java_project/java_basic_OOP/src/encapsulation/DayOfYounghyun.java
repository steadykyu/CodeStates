package encapsulation;

public class DayOfYounghyun {
    public static void main(String[] args) {

        System.out.println("💀 조영현의 하루 💀");

        Car bongorghini = new Car("봉고르기니 무얼실을라고", 20);

        Programmer younghyun = new Programmer("조영현", bongorghini, "코드스테이츠", true);

        younghyun.introduce();
        younghyun.commute();
        younghyun.work();
        younghyun.sleep();
        younghyun.eat();
    }
}
