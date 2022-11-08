package Constructor;

public class Test2 {

    public static void main(String[] args) {
        Example2 example = new Example2();
        Example2 example2 = new Example2("kyuhaKim",28);

        System.out.println("이름은 : " + example.name + "/ 나이는 : " + example.age);
        System.out.println("이름은 : " + example2.name + "/ 나이는 : " + example2.age);

    }
}

class Example2 {
    String name;
    int age;

    public Example2() {
        this("초기값이름입니다", 100);
    };

    public Example2(String name, int age) {
        this.name = name;
        this.age = age;
    };
}