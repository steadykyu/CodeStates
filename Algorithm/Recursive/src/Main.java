import java.util.Arrays;

public class Main {

    // 1~ num 까지의 합
    public int sumTo(int num){
        // 쪼갤수 없는 경우
        if(num==1) return 1;

        // 쪼갤수 있는 경우
        int head = num;
        int tail = num - 1;
        return num + sumTo(num-1);
    }

    // num 이 홀수 인지 재귀를 써서 풀기(%, / 금지)
    public boolean isOdd(int num) {
        //TODO..
        // Base Case : 더이상 쪼갤수 없는 경우
        if(num == 1) return true;
        if(num == 0) return false;

        // Recursive Case
        // 작은 단위로 쪼갤 수 있는 경우
        if(num < 0) return isOdd(num * -1);
        return isOdd(num-2);
    }

    // num 까지의 팩토리얼 구하기
    // num : 0 보다 큰 정수
    public int factorial(int num){
        // base case : 더이상 쪼갤수 없는 경우
        if(num<=1) return 1;
        // recursive case : 작은 단위로 쪼갤수 있는경우
        // f(5) = 5 * f(4)
        return num * factorial(num-1);
    }

    // 피보나치수열 구현 하기( num 번째 값을 구하기 )
    // 0번째는 0, 1번째는 1
    // 그러므로 2번째는 0+1 = 1
    public int fibonacci(int num){
        // base case
        if(num<=1) return num;

        // recursive case
        //fibo(f) :  f(n) = f(n-1) + f(n-2)
        return fibonacci(num-1) + fibonacci(num-2);
    }

    // 배열을 입력받아 모든 요소의 합을 리턴해야 합니다.
    // 빈 배열의 합은 0 입니다.
    public int arrSum(int[] arr){
        // base case
        // 작은 단위로 쪼갤 수 없는 경우
        if(arr.length==0) return 0;

        //recursive case
        int head = arr[0];
        int[] tail = Arrays.copyOfRange(arr,1,arr.length);
        return head + arrSum(tail);
    }

    // 배열을 입력받아 그 길이를 리턴해야 합니다.
    public int arrLength(int[] arr){
        // base case
        // 작은 단위로 쪼갤 수 없는 경우
        if(arr.length == 0){
            return 0;
        }

        // recursive case
        // 작은 단위로 쪼갤 수 있는 경우
        // int head = 1; // 요소 한개
        // int tail = Arrays.copyOfRange(arr,1,arr.length); // 배열 요소를 한개씩 감소시킴 -> 총 재귀 횟수
        return 1+ arrLength(Arrays.copyOfRange(arr,1,arr.length));
    }

    //수(num)와 배열을 입력받아 차례대로 num개의 요소가 제거된 새로운 배열을 리턴해야 합니다.
    public int[] drop(int num, int[] arr){
        // TODO:

        if(num >= arr.length) return new int[]{};
        //base case
        // 더이상 쪼갤수 없는 경우
        // 횟수가 끝났거나, 배열의 길이가 0이 되었을때
        if(num ==0 || arr.length == 0) return arr;

        //recursive case
        // 작은 단위로 쪼갤 수 있는 경우
        // d(2, {1, -2, 1, 3}) -> d(1, drop{-2,1,3})
        int head = num -1;
        int[] tail = Arrays.copyOfRange(arr,1,arr.length);
        return drop(head, tail);
    }

    // 수(num)와 배열을 입력받아 차례대로 num개의 요소만 포함된 새로운 배열을 리턴해야 합니다.
    public int[] take(int num, int[] arr){
        //base Case : 더 이상 쪼개어 생각할 수 없는 경우
        //선택할 요소의 갯수(num)가 배열의 전체 요소의 갯수보다 많은 경우, 입력된 배열을 반환합니다.
        if(num >= arr.length) {
            return arr;
        }
        //선택할 요소의 갯수(num)가 0인 경우, 입력된 배열의 요소가 아무것도 없는 경우에는 빈 배열을 반환합니다.
        if(num == 0 || arr.length == 0) {
            return new int[]{};
        }

        //맨 뒷부분의 요소를 제외한 나머지 배열을 tail이라는 변수에 할당합니다.
        // t(4, {-1, -2, 1, 2,3,4,5}) -> t(4,{-1, -2, 1, 2,3,4})
        int[] tail = Arrays.copyOfRange(arr, 0, arr.length -1);

        //제외한 배열을 포함하여 다시 재귀함수를 실행합니다.
        return take(num, tail);
    }

    // 배열을 입력받아 모든 요소의 논리곱(and)을 리턴해야 합니다.
    public boolean and(boolean[] arr){
        // TODO:
        // base case(더이상 쪼갤 수 없는 경우)
        if(arr.length==0) return true;

        // recursive
        // arr{T , T , F} -> T && arr{T, F}
        // head : arr 첫번째 요소
        // tail : 첫번째 요소를 제거한 배열
        boolean head = arr[0];
        boolean[] tail = Arrays.copyOfRange(arr,1,arr.length);

        return arr[0] && and(tail);
    }

    // 배열을 입력받아 모든 요소의 논리합(or)을 리턴해야 합니다.
    public boolean or(boolean[] arr){
        // TODO:
        // 더이상 쪼갤수 없는 경우
        if(arr.length==0) return false;

        // recursive case
        boolean head = arr[0];
        boolean[] tail = Arrays.copyOfRange(arr,1,arr.length);

        return head || or(tail);

        // if(!head && !or(tail)) return false;
    }


    // 배열을 입력받아 순서가 뒤집힌 배열을 리턴해야 합니다.
    public int[] reverseArr(int[] arr){
        // base case
        // arr 길이 == 0 이면 빈배열 출력
        if(arr.length==0) return new int[0];

        // recursive case
        // rA{1,2,3} -> rA{1,2} + {3}
        // rA{1,2} => {2,1} (tail)
        // new int[]{} = {2,1} + {1}   = tail + head
        int[] head = Arrays.copyOfRange(arr,arr.length-1,arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr,0,arr.length-1));

        int[] res = new int[tail.length + head.length];
        System.arraycopy(head,0,res,0,head.length);
        System.arraycopy(tail,0,res,1,tail.length);
        return res;
    }

    public static void main(String[] args) {
//        Main main = new Main();
//        int output = main.sumTo(10);
//        System.out.println(output);
    }
}

