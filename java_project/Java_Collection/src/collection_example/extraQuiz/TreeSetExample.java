package collection_example.extraQuiz;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 1; treeSet.size() < 6; i++) {
            int num = (int) (Math.random() * 45) + 1;
            System.out.println(i + "번째 num = " + num);

            try { Thread.sleep(1000); } catch (Exception e) {}

            treeSet.add(num);
        }

        System.out.println("당첨 번호 : " + treeSet);
    }
}
