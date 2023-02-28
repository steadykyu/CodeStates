import java.io.*;
import java.util.Arrays;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 오름차순의 배열 원소 주입
        int[] arr1 = new int[n];
        String[] input2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr1[i] = Integer.parseInt(input2[i]);
        }
        // 오름차순의 배열 원소 주입
        int[] arr2 = new int[m];
        String[] input3= br.readLine().split(" ");
        for(int i=0; i<m; i++){
            arr2[i] = Integer.parseInt(input3[i]);
        }

        //        pw.println(Arrays.toString(arr1));
//        pw.println(Arrays.toString(arr2));

        int idx1 = 0; int idx2 = 0;
        int[] result = new int[n+m];
        // n+m 번 반복, i는 result의 index
        for(int i=0 ; i< n+m; i++){
            // 각 배열의 끝점에 도달했을 경우
            if(idx1 == n) result[i] = arr2[idx2++];
            else if(idx2 == m) result[i] = arr1[idx1++];
            // 각 배열의 원소들을 비교해야하는 경우
            else if(arr1[idx1] <= arr2[idx2]) result[i] = arr1[idx1++];
            else result[i] = arr2[idx2++];
        }

        // 출력용 코드
        for(int i=0; i < n+m; i++){
            pw.printf(result[i] + " ");
        }
        pw.flush();
        pw.close();
    }
}
//2 2
//3 5
//2 9