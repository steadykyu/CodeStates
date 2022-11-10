package collection_example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add("Java");
        list.add("egg");
        list.add("tree");

        System.out.println(list.size());

        System.out.println(list.get(0));

        list.add(1,"kkk");

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(i + ":" + str);
        }

        for (String str:list) {
            System.out.println(str);
        }

        System.out.println(list.remove(0));


    }
}
