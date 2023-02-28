package staticMethodTest.subpackage;

import staticMethodTest.subpackage.stringkyu;

public class Main2 {
    public static void main(String[] args) {
        String firstName = "김";
        String lastName = "규하";

        String f_Name = stringkyu.addString(firstName,lastName);
        System.out.println(f_Name);
    }
}
