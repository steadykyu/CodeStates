package staticMethodTest.subpackage;

public class Main3 {
    public static void main(String[] args) {
        String firstName = "김";
        String lastName = "규하";

        String f_Name = stringkyu.addString(firstName,lastName);
        System.out.println(f_Name);
        //Stringkyu 인스턴스 생성 없이
        //Stringkyu의 메서드(명령 모음)을 가져와서 로직을 돌릴수 있다!
    }
}
