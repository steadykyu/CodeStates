package bruteForce;

// 배열안에 특정 값이 존재하는지 찾는 메서드를 구현
public class SequentialSearch {
    public boolean SequentialSearch2(int[] arr, int K) {
        // 검색 키 K를 사용하여 순차 검색을 구현
        // 입력: n개의 요소를 갖는 배열 A와 검색 키 K
        // 결과를 저장할 boolean result선언, 초기값은 false
        // 출력: K값과 같은 요소 인덱스 또는 요소가 없을 때 false

        int n = arr.length;    // 현재의 배열 개수를 n에 할당합니다.
        boolean result = false;
        for(int i = 0; i < n; i++) {
            if(arr[i] == K) {
                result = true;
            }
        }
        return result;
    }

//배열을 순회하는 도중에, 해당하는 값이 발견되더라도 배열을 모두 순회한 이후에 결과값을 리턴

    public static void main(String[] args) {
        SequentialSearch ss = new SequentialSearch();

        int[] arr = new int[]{7, 2, 9, 5, 3, 8};
        System.out.println(ss.SequentialSearch2(arr,8));
    }
}
