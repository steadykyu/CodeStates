package stackAndQueue;

import java.util.*;

public class Browser {
    public ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();
        // 초기화 : 현재 페이지에 start를 넣어줍니다.
        current.push(start);
        // actions 동작
        for(String action : actions){
            // 뒤로가기의 경우("-1"),
            // 1.원래 페이지 -> nextStack 에
            // 2. prevStack top 페이지를 지우면서(pop) -> current
            if(action.equals("-1")){
                if(!prevStack.isEmpty()){ // 뒤로가기가 활성화 : prevStack not empty
                    nextStack.push(current.pop());
                    current.push(prevStack.pop());
                }
            }else if(action.equals("1")){ // 앞으로가기의 경우
                // 앞으로가기의 경우("1"),
                // 1. 원래 페이지 -> prevStack
                // 2. nextStack pop -> current
                if(!nextStack.isEmpty()){ // 앞으로가기가 활성화 : nextStack not empty
                    prevStack.push(current.pop());
                    current.push(nextStack.pop());
                }
            }else{ // 새로운 페이지(알파벳 입력) 접속의 경우
                // 1. 원래 페이지  -> prev , 새로운 페이지 push()
                // 2. nextStack clear (모두 비움)
                prevStack.push(current.pop());
                current.push(action);
                nextStack.clear();
            }
        }
        // 리스트에 스택을 담아 반환(1. prev 2. curr 3. next)
        return new ArrayList<Stack>(){{
            add(prevStack);
            add(current);
            add(nextStack);
        }};
    }
}
// 하나하나 수도 코드 작성하면서 풀자.

// 래퍼런스 코드와 비교하자.
// 1. "비활성화의 경우, 아무것도 하지 않는다." 이 내용을 else if문의 특징을 이용해 한번에 처리했다.
