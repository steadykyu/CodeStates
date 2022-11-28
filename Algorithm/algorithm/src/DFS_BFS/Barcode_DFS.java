package DFS_BFS;

public class Barcode_DFS {
    // 조건1 : 1, 2, 3으로만 이루어져야합니다.
    // 조건2 : 인접한 두개의 부분 수열이 달라야 합니다.
    // 조건3 : 만들 수 있는 바코드중 가장 작은수를 반환 합니다.
    public String barcode(int len) {
        return aux("", len);
    }

    // 왜 거꾸로 뒤집어서 할까?
    // 1212 인경우 재귀로 인해 121 + 2 가 들어온 것이다.
    // 이때 121은 이미 유효성 검사를 받은 문자이므로 다시 검사할 필요가 없다.
    // 즉 새로 들어온 "2"를 기준으로만, "2" != "1", "21" == "21"  두가지를 비교하면 되는 것이다.
    public boolean isVaild(String str){ //1212
        // index 관리를 편하게 하기 위해 reverse를 써주자.
        StringBuffer sb = new StringBuffer(str);
        String reverse = sb.reverse().toString();
        // 인접한 두 개의 부분 수열이 동일한지 확인한다.
        // 재귀로 오는 문자열들은 최대 절반 길이만큼만 두개의 부분 수열이 가능하다.
        // ex) 1213121 -> 1213/121 이 이상의 비교는 불가능
        int halfLen = (int)Math.floor((double) str.length()/2);

        for(int i = 1; i <= halfLen; i++){ // 2121
            if(reverse.substring(0, i).equals(reverse.substring(i,i+i))){
                return false;
            }
        }
        return true;
    }



    // DFS로 구현한것
    public String aux(String str, int len){
        String chr = "123";
        // 탈출 조건 : 유효성을 통과해서 만든 길이 len의 str을 리턴한다.
        if(str.length() == len) return str;
        // 조건을 만족하는 가장 작은 수를 찾고 있으므로,
        // 1, 2, 3 순서대로 검토한다.
        for(int i=0; i < chr.length(); i++){
            String currentStr = str + chr.charAt(i);
            if(isVaild(currentStr)){ // 해당 숫자가 조건2의 조건을 통과한다면
                String founded = aux(currentStr, len);
                if(founded != null) return founded;
            }
        }
        // DFS로 탐색하므로, 가장 좌측부터 탐색한다.
        // 그러므로 제일 작은 값을 return 할테이므로 실제 수(number) 비교는 필요없다.(조건3 만족)

        // 현재 str에서 1, 2, 3을 이어붙여서 유효한 문자열을 만들 수 없는 경우
        return null;
    }
    // 아래 case의 경우를 생각해보자.
    // 1213121 -> 12131213 유효성 문제
    // 121312 + 2 -> 유효성 문제
    // 121312 + 3 -> 1213123 + (1 || 2) -> 12131231


    public static void main(String[] args) {
        Barcode_DFS bd = new Barcode_DFS();
        //len = 1 -> 1
        // 2 -> 12
        // 3 -> 121 1 2 12 21
        // 4 -> 1213 1 2 3 12 21 13
        String output = bd.barcode(3);
        System.out.println(output); // "121"

        output = bd.barcode(7);
        System.out.println(output); // "1213121"

        output = bd.barcode(20);
        System.out.println(output); // "12131231321231213123"

    }
}
