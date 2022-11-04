package staticMethodTest;

public class Main {
    public static void main(String[] args) {
        String firstName = "김";
        String lastName = "규하";

        String f_Name = Stringkyu.addString(firstName,lastName);
        // 인스턴스 생성 없이, Stringkyu의 메서드(명령 모음)을 가져와서 로직을 돌릴수 있다!
        // Java를 실행했을때, 자바 환경에 이러한 기본적으로 필요한 클래스들은 자바 메모리의 클래스 영역에 들어 있기 때문이다.
    }
}
//  Java 환경
class Stringkyu{
    public String str;
    private final byte[] value = new byte[10];
    //String 내부에서 사용되는 필드들...


    static String addString(String f_str, String l_str){
        return f_str + l_str;
    }

    // 다른 String 메서드들.........


}


