package collection_example;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("egg");
        list.add("tree");

        int size = list.size();

        String skill = list.get(0);

        for(int i = 0; i < list.size(); i++){
            String str = list.get(i);
            System.out.println(i + ":" + str);
        }

        for(String str: list){
            System.out.println(str);
        }

        list.remove(0);
    }
}
