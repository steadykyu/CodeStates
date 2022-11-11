package collection_example.extraQuiz;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) arrayList.add(i);

        System.out.println("arrayList = " + arrayList);
        System.out.println("#".repeat(30));

        Iterator<Integer> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println("num = " + iterator.next());
            iterator.remove();
            System.out.println("arrayList = " + arrayList);
            System.out.println();
        }
    }
}
