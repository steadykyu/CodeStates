package queue;

import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);     // 용량이 부족시 IllegalStateException 출력함
        queue.offer(2);// 용량이 부족시 IllegalStateException 출력X
        queue.offer(3);
        queue.offer(4);

        System.out.println("queue 크기 : "+ queue.size()); // 1234
        System.out.println(queue.poll());
        System.out.println("queue 크기 : "+ queue.size()); // 234
        System.out.println(queue.peek());
        System.out.println("queue 크기 : "+ queue.size()); // 234

        // 해당 요소만 지울 수도 있긴 함
        queue.remove(4);

        System.out.println("queue를 String으로 출력해보기 : " + queue.toString());
        System.out.println("queue가 비었나요? : " + queue.isEmpty());
    }
}
