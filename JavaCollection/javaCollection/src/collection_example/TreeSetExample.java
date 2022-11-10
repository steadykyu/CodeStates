package collection_example;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> workers = new TreeSet<>();

        workers.add("Lee Java");
        workers.add("Park Hacker");
        workers.add("Kim Coding");

        System.out.println(workers); // [Kim Coding, Lee Java, Park Hacker]
        System.out.println(workers.first());
        System.out.println(workers.last());
        System.out.println(workers.higher("Lee"));  // Lee Java
        System.out.println(workers.subSet("Kim","Park"));// [Kim Coding, Lee Java]
    }
}
