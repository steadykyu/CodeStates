package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChikenSource_Perm {
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // 1. NPM 을 구해야 함.
        // 2. 항상 1로 시작한다.
        // 3. 000 이 있는 재료는 상한 재료이다.
        // 4. 조합 및 요소는 작은 숫자 -> 큰 숫자로 정렬합니다.


//       가능한 재료 찾기(N) - possibleArr
//       0이 3개이상인 재료 제외하기
        ArrayList<String> possibleArr = new ArrayList<>();
        for(int i=0; i < stuffArr.length; i++){ // 11000
            String str = String.valueOf(stuffArr[i]);
            // 0이 3개 이상인 재료들
            if(isOverZero(str)) continue;
            // 0이 3개 미만인 재료들
            possibleArr.add(str);
        }
//        System.out.println(possibleArr); 확인

        //사용할 수 있는 재료가 없거나, 재료의 양보다 사용해야 할 갯수가 더 많은 경우 null을 반환합니다.
        if(possibleArr.size()==0 || possibleArr.size() < choiceNum) return null;

        ArrayList<Integer> freshArr = new ArrayList<>();
        // String 배열을 Int 배열로
        for(int i=0; i < possibleArr.size(); i++){
            freshArr.add(Integer.parseInt(possibleArr.get(i)));
        }

        Collections.sort(freshArr);

        // 조합할 수 있는 경우의 수 구하기 - 순열 구하기
        // DFS(재귀)를 이용하여 순열 경우의 수 구하기
        // input : possibleArr -> 1, 10, 1100, 1111      isVisited = F F F F
        // 순열 재귀에 필요한 것들을 전부 매개변수로 넣어준다.
        int level = 0;
        boolean[] isVisited = new boolean[freshArr.size()];
        ArrayList<Integer[]> result = new ArrayList<>();
        perm(choiceNum, new Integer[0], result, freshArr, isVisited, level);

        return result;
    }

    boolean isOverZero(String str){
        int zeroCnt = 0;
        // 11000
        for(char s : str.toCharArray()){
            if(s=='0') zeroCnt++;
        }
        if(zeroCnt >= 3) return true;
        else return false;
    }

    public ArrayList<Integer[]> perm(int choiceNum, Integer[] ParmArr, ArrayList<Integer[]> result, List<Integer> freshArr, boolean[] isVisited, int level){
//       String 1, 10, 1100, 1111   level = 0;   isVisited = T F F F , cook = {1}
        //       String 1, 10, 1100, 1111   level = 1;   isVisited = T T F F, cook = {1, 10}
        //       String 1, 10, 1100, 1111   level = 2;   isVisited = T T F F, cook = {1, 10} -> add

        // cook = {1, 1100} , cook = {1, 1111} /
        //탈출 조건
        if(level==choiceNum) {
            result.add(ParmArr);
            return result;
        }

        // 문제 쪼개기
        for(int i=0; i<freshArr.size();i++){
            if(!isVisited[i]) { // 방문 안한경우만 가져온다.
                isVisited[i] = true; // 해당 재료를 사용함을 체크함.
                // 깊은 복사를 위해 ParmArr 참조변수가 아닌 새로운 참조변수를 생성해서 넣어준다.
                Integer[] currentArr = Arrays.copyOf(ParmArr, ParmArr.length + 1);
                currentArr[currentArr.length - 1] = freshArr.get(i);
                // 다시 재귀를 사용한다.
                perm(choiceNum, currentArr, result,freshArr, isVisited,level + 1);
                isVisited[i] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ChikenSource_Perm csp = new ChikenSource_Perm();
        ArrayList<Integer[]> output1 = csp.newChickenRecipe(new int[]{11, 1, 10, 1111111111, 10000}, 4);
        for(int i =0; i < output1.size(); i++){
            System.out.println(Arrays.toString(output1.get(i)));
        }
    }
}

// 수정 전 코드
//    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
//        // 1. NPM 을 구해야 함.
//        // 2. 항상 1로 시작한다.
//        // 3. 000 이 있는 재료는 상한 재료이다.
//        // 4. 조합 및 요소는 작은 숫자 -> 큰 숫자로 정렬합니다.
//
//
////       가능한 재료 찾기(N) - possibleArr
////       0이 3개이상인 재료 제외하기
//        int countZero = 0;
//        ArrayList<String> possibleArr = new ArrayList<>();
//        for(int i=0; i < stuffArr.length; i++){ // 11000
//            String str = String.valueOf(stuffArr[i]);
//            // 0이 3개 이상인 재료들
//            if(isOverZero(str)) continue;
//            // 0이 3개 미만인 재료들
//            possibleArr.add(str);
//        }
////        System.out.println(possibleArr); 확인
//
//        //사용할 수 있는 재료가 없거나, 재료의 양보다 사용해야 할 갯수가 더 많은 경우 null을 반환합니다.
//        if(possibleArr.size()==0 || possibleArr.size() < choiceNum) return null;
//
//        Collections.sort(possibleArr);
//
//        // 조합할 수 있는 경우의 수 구하기 - 순열 구하기
//        // DFS(재귀)를 이용하여 순열 경우의 수 구하기
//        // input : possibleArr -> 1, 10, 1100, 1111      isVisited = F F F F
//        // 순열 재귀에 필요한 것들을 전부 매개변수로 넣어준다.
//        int level = 0;
//        boolean[] isVisited = new boolean[possibleArr.size()];
//        ArrayList<Integer[]> result = new ArrayList<>();
//        perm(possibleArr, choiceNum,result, isVisited,new Integer[0], level);
//
//        return result;
//    }
//
//    boolean isOverZero(String str){
//        int zeroCnt = 0;
//        // 11000
//        for(char s : str.toCharArray()){
//            if(s=='0') zeroCnt++;
//        }
//        if(zeroCnt >= 3) return true;
//        else return false;
//    }
//
//    void perm(ArrayList<String> possibleArr, int choiceNum, ArrayList<Integer[]> result, boolean[] isVisited, Integer[] ParmArr, int level){
////       String 1, 10, 1100, 1111   level = 0;   isVisited = T F F F , cook = {1}
//        //       String 1, 10, 1100, 1111   level = 1;   isVisited = T T F F, cook = {1, 10}
//        //       String 1, 10, 1100, 1111   level = 2;   isVisited = T T F F, cook = {1, 10} -> add
//
//        // cook = {1, 1100} , cook = {1, 1111} /
//        //탈출 조건
//        if(level==choiceNum) result.add(ParmArr); // Integer[]가 들어감....
//
//        // 문제 쪼개기
//        for(int i=0; i<possibleArr.size();i++){
//            if(!isVisited[i]) { // 방문 안한경우만 가져온다.
//                isVisited[i] = true; // 해당 재료를 사용함을 체크함.
//                // 깊은 복사를 위해 ParmArr 참조변수가 아닌 새로운 참조변수를 생성해서 넣어준다.
//                Integer[] currentArr = Arrays.copyOf(ParmArr, ParmArr.length + 1);
//                currentArr[currentArr.length - 1] = Integer.parseInt(possibleArr.get(i));
//                // 다시 재귀를 사용한다.
//                perm(possibleArr, choiceNum, result, isVisited, currentArr, level + 1);
//                isVisited[i] = false;
//            }
//        }
//    }