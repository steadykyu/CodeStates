package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 중복 순열 문제
public class RockScissorsPaper_Perm {

    public ArrayList<String[]> rockPaperScissors(int rounds) {

        ArrayList<String[]> outcomes = new ArrayList<>();
        // 가위바위보 판수, 요소로 사용할 배열, 최종 ArrayList를 매개변수로 전달
        return permutation(rounds, new String[]{} ,outcomes);

    }

    public ArrayList<String[]> permutation(int roundToGo, String[] playedSoFar, ArrayList<String[]> outcomes){
        // 탈출 조건
        // roundToGo==0 , playedSoFar = {"rock", "rock", "rock", "rock", "rock"}, outcomes -> {"rock", "rock", "rock", "rock", "rock"}
        // roundToGo==0 , playedSoFar = {"rock", "rock", "rock", "rock", "paper"}, outcomes ->{{"rock", "rock", "rock", "rock", "rock"}, {"rock", "rock", "rock", "rock", "paper"}}
        if(roundToGo==0){
            outcomes.add(playedSoFar);
            return outcomes;
        }

        // 사실 불변이므로, 필드에 사용해도 된다.
        // 그래도 실코드 관점에서는 왠만하면 필드에는 안쓰는게 좋다.
        String[] rps = new String[]{"rock", "scissors", "paper"};

        for(int i = 0; i < rps.length; i++) {
            // rps의 i번째 요소
            String currentPlay = rps[i]; // rock

            // permutate(본인)에 기존 rounds에서 하나 뺀 숫자와,
            // 일회용 배열 playedSoFar에 currentPlay를 삽입하여 재귀를 실행합니다.
            String[] concatArray = Arrays.copyOf(playedSoFar, playedSoFar.length+1);
            concatArray[concatArray.length-1] = currentPlay;

            outcomes = permutation(roundToGo-1,concatArray,outcomes);
        }
        return outcomes;
    }
    // 1. 재귀를 호출하여 탈출조건에 의해 return 받은 이후, 남은 for문을 진행하는 방식이 쉽게 보이지 않는다.
    //  - 탈출조건에 의해 재귀가 return 된 후, for문의 남은 부분 실행을 돌아오는 해당 움직임을 백 트래킹이라고 한다.

    // 2. 깊은 복사를 위해 새로 생성한 concatArray 에, 매개변수 playedSoFar를 이용한 배열을 삽입해주고 있다.
    //  - 만약 playedSoFar를 변화시킨다면, 얕은 복사가 일어난다.
    //  - 재귀 깊은곳에서 사용된 playedSoFar 를 복사해와서 값을 추가하므로, 5라운드 이상의 가위,바위,보가 출력된다.
    public static void main(String[] args) {
        RockScissorsPaper_Perm rpp = new RockScissorsPaper_Perm();
        ArrayList<String[]> output = rpp.rockPaperScissors(5);

        for(int i=0; i < output.size(); i++){
            System.out.println(Arrays.toString(output.get(i)));
        }
    }
}
