package encapsulation;

class Programmer extends Person {

    // 상위클래스 Person 에서 필드를 가져온다.
    private String company;
    private boolean hasTooMuchWork;

    public Programmer(String name, Car car, String company, boolean hasTooMuchWork) {
        super(name, car);
        this.company = company;
        this.hasTooMuchWork = hasTooMuchWork;
    }

    public void work() {
        System.out.println("근무를 시작합니다. ");
        System.out.println("타닥..타닥...타다닥... 탁!!!");
        System.out.println("이게 왜 안되지..? ");
        System.out.println("타닥..타닥...타다닥... 탁!!!");
        System.out.println("이게 왜 되지..? ");
        System.out.println();
    }

    public void commute() {
        System.out.printf("%s를 타고 %s로 출근합니다. \n", super.getCar().getName(), company);
        super.drive();
        System.out.printf("%s에 도착했습니다.\n", company);
        System.out.println();
    }

    public void sleep() {
        if (hasTooMuchWork) System.out.println("잠을 잘 수 없습니다...");
        else super.sleep();
        System.out.println();
    }

    public void eat() {
        if (hasTooMuchWork) System.out.println("허겁지겁 후루룩");
        else super.eat();
        System.out.println();
    }

    public void introduce() {
        super.introduce();
        System.out.printf(
                "%s에서 일하고 있으며, %s",
                company,
                hasTooMuchWork ? "오늘은 야근을 합니다...\n" : "오늘은 정시에 퇴근합니다. 룰루~\n"
        );
    }
}
