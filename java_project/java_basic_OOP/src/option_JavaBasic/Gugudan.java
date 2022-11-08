package option_JavaBasic;

import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smallDan = 2;
        int bigDan = 9;

        System.out.printf("[안내]희망하는 구구단을 숫자로 입력해주세요 (2 ~ 9) : ");
        // 1. 단입력
        int dan = Integer.parseInt(scanner.nextLine());
        // 2. 단 범위를 넘어가는 값 입력시, 경고 출력
        if(dan < smallDan || dan > bigDan) {
            System.out.printf("[경고]구구단은 %d단 ~ %d단 까지만 선택할 수 있습니다.",smallDan, bigDan);
        }
        else{
            System.out.println(dan+"단이 입력되었습니다.");
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + " * " + i + " = " + dan * i);
            }
        }


    }
}
