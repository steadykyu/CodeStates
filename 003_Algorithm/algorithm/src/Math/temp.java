package Math;

import java.util.ArrayList;
import java.util.Collections;

public class temp {

    public static void main(String[] args) {
        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("1");
        strArr.add("101");
        strArr.add("11");

        Collections.sort(strArr);
        System.out.println(strArr);


        ArrayList<Integer> intArr = new ArrayList<>();
        intArr.add(1);
        intArr.add(101);
        intArr.add(11);

        Collections.sort(intArr);
        System.out.println(intArr);
    }
}
