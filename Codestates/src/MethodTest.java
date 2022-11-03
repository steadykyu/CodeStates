public class MethodTest {

    void printHello() { // 반환타입이 void인 메서드
        System.out.println("hello!");
    }

    int getNumSeven() { // 매개변수가 없는 메서드
        return 7;
    }

    Double multiply(int x, double y) { // 매개변수가 있는 메서드
        double result = x * y;
        return result;
    }

    void printAll(){
        printHello();
        System.out.println(getNumSeven());
        System.out.println(multiply(4,4.0));
    }
    public static void main(String[] args) {

    }

}
