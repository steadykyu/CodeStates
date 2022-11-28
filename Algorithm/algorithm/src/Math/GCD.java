package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GCD {
    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {

        ArrayList<Integer[]> res = new ArrayList<>();
        // 두 수의 최대 공약수를 구한다.
        int gcd = gcd(M,N);

        // 최대공약수의 약수이면 빼빼로를 나누어 줄 수 있다.
        // 약수는 제곱근 까지만 순회하면, 시간복잡도를 최대로 줄일 수 있다.
        int sqrt = (int)Math.floor(Math.sqrt(gcd));

        for(int left=1; left<= sqrt; left++){
            if(gcd % left ==0){ // 최대공약수의 약수 중 제곱근 보다 작은 약수의 경우 ( 1, 2 )
                // 약수 , M/약수 , N/약수
                res.add(new Integer[]{left,M/left,N/left});

                // 최대공약수의 약수중 제곱근 보다 큰 약수의 경우 (4)
                if(left * left < gcd){ // left가 제곱근 보다 작은 경우
                    int right = gcd / left; // 최대공약수를 제곱근 보다 작은 수로 나누면 제곱근 보다 큰 약수를 구할수 있다.( 4/1 = 4)
                    res.add(new Integer[]{right,M/right,N/right});
                }
            }
        }

        // 빼뺴로를 받게 되는 직원의 수를 기준으로 오름차순으로 정렬(배열의 맨 앞 숫자 기준으로 정렬)
        Collections.sort(res, new Comparator<Integer[]>() { // Comparator interface의 구현체를 익명객체로 생성
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0].compareTo(o2[0]); // 첫번째 요소를 기준으로 오름차순
            }
        });

        return res;
    }
    // 유클리드 호제법
    public int gcd(int M, int N){
        if(M % N == 0) return N;
        return gcd(N,M % N);
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        int M = 4;
        int N = 8;
        ArrayList<Integer[]> output = gcd.divideChocolateStick(M, N);

        for(Integer[] arr: output){
            System.out.println(Arrays.toString(arr));
        }
        // [[1, 4, 8], [2, 2, 4], [4, 1, 2]]
    }
}
// 1. 유클리드 호제법 :  (a>b) a와 b의 최대 공약수는 나머지(a%b) 와 b의 최대 공약수와 같다.

// 2. A 수의 약수의 개수 : A의 제곱근 까지 for문을 이용하여 시간복잡도를 절약하면서 약수의 개수를 구할 수 있다.
// - 수 A 를 제곱근 보다 작은 수로 나누면 제곱근 보다 큰 약수를 구할수 있다.(반대도 마찬가지)
// - 그러므로 약수의 개수 = 제곱근보다 작은 약수의 개수 X 2 + {? == (제곱근 있을때=1 : 제곱근 없을때=0)}
// - ex) 1 2 (제곱근) 4 8 -> 8/2 = 4, 8/1 = 8

// 3. 정렬을 위한 Comparator<타입> 을 익명객체로 구현체를 만들어 주고 있다.
