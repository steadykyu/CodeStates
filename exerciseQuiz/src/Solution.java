import java.util.*;

public class Solution {
    public String readVertically(String[] arr) {
        String res = "";
        int len = 0;
        // 가장 긴 문자열의 길이 찾기
        for(String s : arr){
            len = Math.max(s.length(),len);
        }

        // 문자열 배열 동시 탐색
        for(int i = 0; i < len ; i++){ // 가장 긴 문자열 만큼 순회
            for(int j=0; j < arr.length; j++) // arr 요소 순회
                // if i > 요소 인덱스 최대값 -> 아무일도 X
                if(i > arr[j].length()-1) continue;

            res += arr[j].charAt(i);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.remove());
        System.out.println(queue.size());

    }
}