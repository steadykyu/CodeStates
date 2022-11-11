package collection_example.extraQuiz;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 1; hashSet.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            System.out.println(i + "번째 num = " + num);

            try { Thread.sleep(1000); } catch (Exception e) {}

            hashSet.add(num);
        }

        System.out.println("당첨 번호 : " + hashSet);
    }
}
