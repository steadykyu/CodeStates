package innerclass;

class Outer2 { //외부 클래스
    private String outer_ins = "외부클래스속 인스턴스변수";
    private static String outer_static = "외부클래스속 스태틱변수";

    void getPrint() {
        System.out.println("인스턴스 메서드");
    }

    static void getPrintStatic() {
        System.out.println("스태틱 메서드");
    }

    static class StaticInClass { // 정적 내부 클래스
        String inner_ins = "static 내부클래스속 인스턴스변수";
        static String inner_static = "static 내부클래스속 스태틱변수";
        void test() {
//            System.out.println(outer_ins); // 컴파일에러
            System.out.println("Outer num = " + outer_static + "(외부 클래스의 스태틱 변수)");
            System.out.println("Outer num = " + inner_ins + "(내부 클래스의 인스턴스 변수)");
            System.out.println("Outer num = " + inner_static + "(내부 클래스의 스태틱 변수)");
            getPrintStatic();
            // outer_ins 와 getPrint() 는 정적 멤버가 아니라 사용 불가.
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        //정적 inner 클래스의 객체 생성 - 인스턴스 메서드 test 호출
        Outer2.StaticInClass a = new Outer2.StaticInClass(); 
        a.test();

        System.out.println();
        System.out.println("=====Outer2 객체를 생성하지 않고, 스태틱 변수값을 꺼내오는 모습========");
        System.out.println(Outer2.StaticInClass.inner_static); // static 내부클래스속 스태틱변수
    }
}

// 출력결과
//    Outer num = 외부클래스속 스태틱변수(외부 클래스의 스태틱 변수)
//    Outer num = static 내부클래스속 인스턴스변수(내부 클래스의 인스턴스 변수)
//    Outer num = static 내부클래스속 스태틱변수(내부 클래스의 스태틱 변수)
//    스태틱 메서드
//
//=====Outer2 객체를 생성하지 않고, 스태틱 변수값을 꺼내오는 모습========
//static 내부클래스속 스태틱변수

