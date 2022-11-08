package option_JavaBasic;

public class fibonachi {
    public static void main(String[] args) {
        int num = 6;
        int[] arr = new int[num+1];
        arr[1] = 1; arr[2] =1;
        for(int i=3; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        for(int i=1; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
}
