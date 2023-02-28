package greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class LoadingInBox {
    public int movingStuff(int[] stuff, int limit) {
        // 조건 1 : 무게제한
        // 조건 2 : 박스는 한번에 최대 2개의 짐을 넣을수 있다
        // 조건 3 : 박스의 개수를 최소로 하여 return
        // 최선의 선택은 가장 무거운 짐과 가장 가벼운 짐이 박스에 들어가는 경우이다.
        // 박스에 못들어가는 경우 무거운짐보다 조금 가벼운짐과 가장 가벼운 짐을 비교하여 박스에 들어가는지 체크한다.

        // 짐을 무게순으로 오름차순 정렬
        Arrays.sort(stuff);
        // 가장 가벼운 짐의 인덱스
        int leftIdx = 0;
        // 가장 무거운 짐의 인덱스
        int rightIdx = stuff.length-1;
        int twoStuff =0; // 한번에 2개를 옮길 수 있는 개수
        // int count=0;
        while(leftIdx < rightIdx) {
            // 가장 가벼운 짐과 무거운 짐의 합이 limit 보다 작거나 같으면 2개를 한번에 나를 수 있다
            if (stuff[leftIdx] + stuff[rightIdx] <= limit) {
                // 다음 짐을 확인하기 위해 가장 가벼운 짐과 무거운 짐을 가리키는 인덱스를 옮겨주고
                leftIdx++;
                rightIdx--;
                // 한번에 2개 옮길 수 있는 개수를 +1 해준다
                twoStuff++;
                // count += 1;
            } else {
                // 위 조건에 맞지 않는 경우는 한번에 한 개만 나를 수 있는 경우이기 때문에
                // 무거운 짐만 포장한다. -> 그냥 지나가서 stuff.length를 건드리지만 않는다면 포장한다
                //가장 무거운 짐의 인덱스만 옮겨준다
                rightIdx--;
                // count += 1;
            }
        }
        // 전체 짐의 개수에서 한번에 2개를 나를 수 있는 경우를 빼 주면 총 필요한 박스의 개수를 구할 수 있다
        return stuff.length - twoStuff;
    }
    // 만약 count로 세려고 한 경우에는 leftIdx == rightIdx 일때 while을 탈출하므로, 예외처리를 해주어야한다.

    // 참고 : Arrays.sort(stuff, Collections.reverseOrder());
    // 컴파일에러 - 기본형의 내림차순은 오름차순 후 뒤집어줄 수 밖에없다.

    public static void main(String[] args) {
        LoadingInBox lib = new LoadingInBox();

        int output3 = lib.movingStuff(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output3); // 4

//        int output = lib.movingStuff(new int[]{70, 50, 80, 50}, 100);
//        System.out.println(output); // 3
//
//        int output2 = lib.movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
//        System.out.println(output2); // 4


    }
}





