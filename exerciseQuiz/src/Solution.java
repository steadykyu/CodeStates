import java.util.*;

public class Solution {
    public String letterCapitalize(String str) {
        // TODO:
        String res ="";
        if(str.length()==0) return "";
        // split이 어떻게 쪼개주는가?
        String[] strArr = str.split(" ");

        for(String eachStr : strArr){
            // 맨 앞글자를 대문자로 바꾸어주어야한다.
            String tmp = "";
            System.out.println("문자열은 = " + eachStr);
            char[] chArr = eachStr.toCharArray();
            for(int i=0; i < chArr.length; i++){
                if(i==0){
                    tmp += Character.toUpperCase(chArr[i]);
                }else tmp += chArr[i];
            }
            res = res + tmp + " ";
        }
        return res.substring(0,res.length()-1);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.println(sol.letterCapitalize("    "));
        String[] blankArr = new String("a    b").split(" ");

        for (String b : blankArr){
            System.out.println(b);
        }
    }
}