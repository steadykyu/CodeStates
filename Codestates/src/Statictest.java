public class Statictest {
    public static void main(String[] args) {
        StaticExample staticExample = new StaticExample();
        System.out.println(staticExample.num1);
        System.out.println(StaticExample.num2);
    }
}
class StaticExample {
    int num1 = 10;
    static int num2 = -10;
}
