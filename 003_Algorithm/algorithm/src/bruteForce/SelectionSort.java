package bruteForce;

import java.util.Arrays;

public class SelectionSort {
    // 주어진 배열을 Selection Sort로 오름차순 정렬합니다.
    public int[] SelectionSort(int[] arr){
        // 입력: 정렬 가능한 요소의 배열 A
        // 출력: 오름차순으로 정렬된 배열
        for(int i=0; i < arr.length -1 ;i++){
            // 배열의 0번째 인덱스부터 마지막인덱스까지 반복합니다.
            // 현재 값 위치(i)에 가장 작은 값을 넣을 것입니다
            int min = i;
            // 현재 인덱스를 최소값의 인덱스를 나타내는 변수에 할당합니다.
            for(int j= i+1; j < arr.length; j++){
                // 현재 i에 +1을 j로 반복문을 초기화하고 i 이후의 배열요소과 비교하는 반복문을 구성합니다.
                if(arr[j] < arr[min]){
                    // j인덱스의 배열 값이 현재 인덱스의 배열 값보다 작다면
                    min = j;
                    // j 인덱스를 최소를 나타내는 인덱스로 할당합니다.
                }
            }
            // 반복문이 끝났을 때(모든 비교가 끝났을때) min에는 최소값의 인덱스가 들어있습니다.
            // i값과 최소값을 바꿔서 할당합니다.
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        // 모든 반복문이 끝나면 정렬된 배열을 반환합니다.
        return arr;
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        System.out.println(Arrays.toString(ss.SelectionSort(new int[]{9, 4, 8, 3, 1, 5})));
    }
}
