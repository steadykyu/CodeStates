package staticMethodTest;

import staticMethodTest.subpackage.stringkyu;

public class Main {
    public static void main(String[] args) {
        String firstName = "김";
        String lastName = "규하";

        String f_Name = stringkyu.addString(firstName,lastName);
        System.out.println(f_Name);
        // 인스턴스 생성 없이, Stringkyu의 메서드(명령 모음)을 가져와서 로직을 돌릴수 있다!
        // Java를 실행했을때, 자바 환경에 이러한 기본적으로 필요한 클래스들은 자바 메모리의 클래스 영역에 들어 있기 때문이다.
    }
}


