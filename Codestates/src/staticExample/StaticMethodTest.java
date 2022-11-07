package staticExample;

public class StaticMethodTest {
    int instanceVal = 10;
    static int staticVal = 1000;

    public void instanceMethod(){
        System.out.println(instanceVal);
        System.out.println(staticVal);
        staticMethod();

    }
    private static void staticMethod(){
//        System.out.println(instanceVal); // 컴파일 오류 발생
        //Non-static field 'instanceVal' cannot be referenced from a static context
        System.out.println(staticVal);
//        instanceMethod(); //컴파일 오류 발생
        //Non-static method 'instanceMethod()' cannot be referenced from a static context
    }

    public static void main(String[] args) {
        StaticMethodTest smt = new StaticMethodTest();
//        staticExample.StaticMethodTest.instanceMethod();
        smt.instanceMethod();
    }

    //출력 결과
//    10
//    1000
//    1000
}
