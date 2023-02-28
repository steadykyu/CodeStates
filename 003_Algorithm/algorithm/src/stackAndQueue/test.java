package stackAndQueue;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("김");
        stack.push("규");
        stack.push("하");

        System.out.println(stack.toString());
        System.out.println("peek() 값 = " + stack.peek());

        System.out.println("Stack의 크기 = " + stack.size());
        System.out.println(stack.pop());
        System.out.println("Stack의 크기 = " + stack.size());
        System.out.println(stack.peek());
        System.out.println("Stack의 크기 = " + stack.size());

        System.out.println("Stack이 비었나요? " + stack.empty());

        System.out.println("String으로 출력해보기 " + stack.toString());
        System.out.println("search(규) 대상이 있는 경우 출력순서를 반환 = " + stack.search("규"));
        System.out.println("search(김) 대상이 있는 경우 출력순서를 반환 = " + stack.search("김"));
        System.out.println("search(하) 대상이 없는 경우 = "+ stack.search("하"));
        
        // 이외의 Vector 클래스가 가진 메서드 사용가능
    }
}
