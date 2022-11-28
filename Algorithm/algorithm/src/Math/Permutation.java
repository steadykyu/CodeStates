package Math;

import java.util.Arrays;
// DFS 를 이용해서 순열 만들기
public class Permutation {
    // 참고 :  필드변수는 변하지 않는 값일때만 쓰는게 좋다.
    // 현재는 깔끔하게 로직을 보이기 위해 static으로 선언했다.
    static int n=5;
    static int r=3;
    String[] initArray = new String[]{"A", "B", "C", "D", "E"};
    String[] resultArray = new String[r]; // r개 만큼 생성
    boolean[] isVisit = new boolean[n]; // 요소가 방문 했는지 아닌지를 나타내는 배열
    int cnt =0;
    public void perm(int count){
        // 탈출 조건
        if(count==r){
            System.out.println(Arrays.toString(resultArray));
            cnt++;
            return;
        }

        // DFS 구조로 동작하도록 작성하기
        for(int i=0; i < n; i++){
            if(isVisit[i]) continue;
            else{
                // 방문임을 확인
                isVisit[i] = true;
                resultArray[count] = initArray[i];
                perm(count+1); // 한글자를 입력해 준후, 다음 글자를 찾으러 간다.
                isVisit[i] = false; // 다른 Level에서도 사용하기 위해 상태를 false로 바꾸어준다.
            }
        }
    }

    public static void main(String[] args) {
        // 5P3
        Permutation p = new Permutation();
        p.perm(0); // 찾은 요소의 개수가 0부터 시작
        System.out.println("개수는 = "+ p.cnt);
    }
}
// 1. DFS Level(depth)를 나타내는 count가 뽑아야하는 개수(r)에 도달했을 때 재귀를 탈출시킨다.
//  - 이전값을 이용할 필요가 없으므로, 메서드의 return 타입은 void로 설정한다.

// 2. DFS 구조를 이용하여, 각 문자마다 모든 문자를 만나도록 탐색한다.
//  - 한 depth 마다 for문 만큼 실행하는 구조이다.
//  - 단 isVisit 라는 이전에 값이 사용되었는지를 알려주는 배열을 이용하여, 중복해서 오는 경우를 제거해준다.(ex - AAB)
//  - 그러므로 모든 문자를 탐색하는 것이다.(A -> A(x) B C D E , A B -> A(x) B(x) C D E)
//  - for문 속에서 재귀메서드를 호출해서 return 값을 얻은 후(=백트래킹 이후)의 남은 소스코드와 다시 남은 for문이 동작하는 모습이 잘 안보일 수 있다.
//  - 이는 재귀의 depth 별로 그려보면, 좀 더 편하게 구조를 알아챌 수 있다.

// 3. isVisit[i] = false; :
//   - 트리 끝까지 탐색후, for문으로 인해 해당 글자가 다시 나올일은 없다. 다른 count(Level)에서 사용될 수 있도록 상태를 false로 바꾸어준다.
