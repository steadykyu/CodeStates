package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 멱집합을 이해하자.
public class PowerSet {

    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        Stack<String> stack = new Stack<>();

        ArrayList<String[]> res = new ArrayList<>();

        // 재료들을 오름차순으로 정렬합니다.
        Arrays.sort(sideDishes);

        // DFS 로 탐색하기
        // 가장 최신의 자료를 제거해주기 위해 stack을 사용
        // 최종 List, 원본 배열, depth를 매개변수로 사용한다.
        res = permutation(stack, res,sideDishes, 0);


        // 결과를 오름차순 순서로 정렬해준다.
        res.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));

        return res;
    }

    // 모든 조합을 검사하는 재귀함수를 작성한다.
    ArrayList<String[]> permutation(Stack<String> stack, ArrayList<String[]> res, String[] sideDishes, int idx){
        // stack = [], idx = 0, sideDishes = [e, f, k] , res = <[e,f,k]>
        // 탈출 조건
        if(idx>=sideDishes.length){
            // stack 컬렉션을 String[]로 생성.
            String[] arr = stack.toArray(new String[0]);
            res.add(arr); // String[] 을 만들어와야함.
            return res;
        } else{
            // idx에 해당하는 음식이 부분집합에 포함된 경우
            stack.push(sideDishes[idx]);
            permutation(stack, res, sideDishes,idx + 1);

            // idx에 해당하는 음식이 부분집합에 포함되지 않은 경우
            stack.pop();
            permutation(stack, res, sideDishes,idx + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        PowerSet ps = new PowerSet();
        ArrayList<String[]> result = ps.missHouseMeal(new String[]{"pasta", "oysterSoup", "beefRibs", "tteokbokki"});
        for(String[] s : result){
            System.out.println(Arrays.toString(s));
        }
    }
}

// 1. push한 결과값에 pop 한 결과를 다시 재귀로 돌려주는 방식이다.
//  - push() 후 의 값은 idx일때의 요소(음식)이 포함되어 있다
//  - pop() 후 의 값은 idx일때의 요소(음식)이 포함되어 있지 않다.

// 2. res.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));
//  - Collection을 정렬하기 위해 람다식을 이용하여 메서드 구현체를 만들고 매개변수에 넣었다.

// 몰라서 case 다적었다 ㅡㅡ; 노션에 그림으로 정리해둔거 보자.
// idx == 0 , push -> stack : e
// idx == 1 , push -> stack : e f
// idx == 2 , push -> stack : e f k    --> idx == 3 , add([e, f, k])
// idx ==2 , pop -> stack : e f        --> idx == 3 , add(e, f)

// idx == 1, pop -> stack : e
// idx == 2, push -> stack : e k        --> idx ==3 , add(e, k)
// idx == 2, pop -> stack : e           --> idx == 3, add(e)

// idx==0 , pop -> stack []
// idx==1 , push -> stack f
// idx==2 , push -> stack : f, k         --> idx ==3, add(f,k)
// idx==2 , pop -> stack : f        --> idx ==3, add(f)

//idx ==1 , pop -> stack []
// idx==2 , push -> stack k           --> idx ==3 , add(k)
// idx==2 , pop -> stack []           --> idx ==3, add([])

// res = <[e, f, k], [e,f], [e,k], [e], [f,k], [f], [k], [] >