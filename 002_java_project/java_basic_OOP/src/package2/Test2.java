package package2;

//파일명 Test2.java
import package1.Parent;

class Child extends package1.Parent {  // package1으로부터 Parent 클래스를 상속
    public void printEach() {
        // System.out.println(a); // 에러 발생!
        // System.out.println(b);
        System.out.println(c); // 다른 패키지의 하위 클래스(protected)
        System.out.println(d);
    }
}

public class Test2 {
    public static void main(String[] args) {
        Parent p = new Parent();

//        System.out.println(p.a); // public을 제외한 모든 호출 에러!
//        System.out.println(p.b);
//        System.out.println(p.c);
        System.out.println(p.d);

        Child child = new Child();
        System.out.println("하위 클래스인 child 속 메서드 출력 결과");
        child.printEach();
    }
}
