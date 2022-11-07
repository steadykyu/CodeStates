package encapsulation;

public class DayOfMinsang {
    public static void main(String[] args) {

        System.out.println("🌈 구민상의 하루 🌈");

        Car lamborghini = new Car("람보르기니 무르시엘라고", 100);

        System.out.println(lamborghini);

        Person minsang = new Person("구민상", lamborghini);

        minsang.introduce();
        minsang.eat();
        minsang.drive();
        minsang.sleep();

    }
}
