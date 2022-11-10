package staticMethodTest.subpackage;

//  Java 환경
public class stringkyu {
    public String str;
    private final byte[] value = new byte[10];
    //String 내부에서 사용되는 필드들...


    public static String addString(String f_str, String l_str) {
        return f_str + l_str;
    }

    // 다른 String 메서드들.........
}
