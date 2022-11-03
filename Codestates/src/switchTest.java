import java.util.Scanner;

public class switchTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("====연산자만 입력해주세요====");
        String operatorWord = input.next();
        outerloop:
        while(true){
            switch (operatorWord){
                case "+":
                case "-":
                case "*":
                case "/":
                    break outerloop;
                default: {
                    System.out.println("연산자를 다시 입력해주세요");
                    operatorWord = input.next();
                    continue;
                }
            }
        }
    }
}
