package Math;

import java.util.Arrays;

// DFS를 이용해서 조합 만들기
public class Combination {
    static int n=5;
    static int r=3;
    String[] initArray = new String[]{"A", "B", "C", "D", "E"};
    String[] resultArray = new String[r]; // r개 만큼 생성


    void combi(int count, int start){ // 요소의 개수, 시작점
        // 탈출 조건
        if(count==r) {
            System.out.println(Arrays.toString(resultArray));
            return;
        }

        // 문제 쪼개기
        for(int i=start; i < n; i++){
            resultArray[count] = initArray[i];
            combi(count+1,i+1); // 찾은 글자의 다음부터 시작 하도록 한다.
        }
    }

    public static void main(String[] args) {
        Combination c = new Combination();
        c.combi(0,0);
    }
}
// 1. DFS Level인 count가 뽑아야하는개수(r)에 도달했을 때 재귀를 탈출시킨다.
//  - 이전값을 이용할 필요가 없으므로, 메서드의 return 타입은 void로 설정한다.
// 2.combi(count+1,i+1);
//  - DFS 구조를 이용한다. (count로 순회하는 재귀구조)
//  - 단 각 문자마다 찾은 시점부터 한칸 뒤의 문자부터 탐색하도록 start 변수부터 시작한다.
//  - 각 글자의 다음 인덱스부터 for문이 시작하므로, 이전에 나왔던 조합의 경우의 수들은 다 제외된다.