package exceptionExample;

public class ThrowExceptionTest {

    public static void main(String[] args) {
        // Unhandled exception: java.lang.ClassNotFoundException
        // 예외처리를 해달라고 컴파일 오류가 발생
        //throwException();

        try{
            throwException();
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    static void throwException() throws ClassNotFoundException, NullPointerException{
        Class.forName("java.lang.StringX"); //예외 발생!!
    }
}
