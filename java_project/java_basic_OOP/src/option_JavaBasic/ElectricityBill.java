package option_JavaBasic;

import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        // 1.전기량을 입력받는다.
        Scanner scan = new Scanner(System.in);
        int electronicAmount = Integer.parseInt(scan.nextLine());

        double below100=0, below150=0, below200=0, below300=0, below400=0, below500 = 0, above500=0;
        // 2. 전기량에 맞게 가격을 결정한다.
        // 99kWh, 150kWh, 250kWh, 301kWh, 450kWh, 510kWh 사용량 각각 구간마다 전기 요금이 다르다.
        // 저압의 경우 100kWh 이하는 kWh당 60.7원,
        // 100kWh 초과는 125.9원, 200kWh 초과는 187.9원
        // 300kWh 초과는 280.6원, 400kWh 초과는 417.7원
        // 500kWh초과는 670.6원의 전력량 요금을 내야한다.
        // ex 400
        for(int i=1; i <= electronicAmount; i++){
            if(i <= 100) {
                below100 += 60.7;
                System.out.println(below100);
            }
            else if(i <= 200) below200 += 125.9;
            else if(i <= 300) below300 += 187.9;
            else if(i <= 400) below400 += 280.6;
            else if(i <= 500) below500 += 417.7;
            else above500 += 670.6;
        }
        System.out.println("100이하 요금 : " + Math.ceil(below100));
        System.out.println("200이하 요금 : " + Math.ceil(below200));
        System.out.println("300이하 요금 : " + Math.ceil(below300));
        System.out.println("400이하 요금 : " + Math.ceil(below400));
        System.out.println("500이하 요금 : " + Math.ceil(below500));
        System.out.println("500이상 요금 : " + Math.ceil(above500));


    }
}
