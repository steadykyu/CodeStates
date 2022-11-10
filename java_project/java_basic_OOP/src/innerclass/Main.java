package innerclass;

class Outer1 { //외부 클래스
    private String outer_ins = "외부클래스속 인스턴스변수";    // 인스턴스 변수

    static String outer_static = "외부클래스속 스태틱변수";   // 정적 변수
    void test() {
        int num2 = 6;       // 지역 변수

        class LocalInClass { //지역 내부 클래스
            String Inner_ins = "내부클래스속 인스턴스변수";
//            static String Inner_static = "내부클래스속 인스턴스변수";
            // 컴파일 오류 : Java 17에서는 가능한데 11에서는 불가능하다.
            void getPrint() {
                System.out.println(outer_ins);  // 외부클래스속 인스턴스변수
                System.out.println(outer_static); // 외부클래스속 스태틱변수
                System.out.println(Inner_ins); // 내부클래스속 인스턴스변수
            }
        }
        LocalInClass localInClass = new LocalInClass();
        localInClass.getPrint();
    }
}
public class Main {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        outer1.test();
    }
}

