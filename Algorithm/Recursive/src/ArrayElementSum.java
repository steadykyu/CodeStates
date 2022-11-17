
public class ArrayElementSum {
    // arrsum : [int] -> int
    public int arrsum(int[] arr){
        // Base Case : 문제를 더 이상 쪼갤 수 없는 경우
        // arrSum: arrSum(new int[]{}) -> 0
        if(arr.length == 0){
            return 0;
        }

        // Recursive Case : 그렇지 않은 경우
        // head : 배열의 첫요소 =  arr[0]
        // tail : 나머지 배열
        // arrsum[new int[e1 ~ en] = head + tail
        // arrSum([e1, e2, ... , en]) = arrSum(new int[]{e1} + arrSum(new int[]{e2, ..., en]}
        int[] newArr = new int[arr.length-1];
        System.arraycopy(arr,1,newArr,0,newArr.length);
        return arr[0] + arrsum(newArr);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ArrayElementSum aes = new ArrayElementSum();
        System.out.println(aes.arrsum(arr));
    }
}
// 재귀를 이용해서 배열의 합을 구해보세요