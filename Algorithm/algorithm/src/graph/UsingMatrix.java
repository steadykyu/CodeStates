package graph;

import java.util.Arrays;

// 정점(from)이 직접/간접적으로 정점(to)에 연결될수 있는지 결과를 구하는 메서드 구현
public class UsingMatrix {
    public boolean getDirections(int[][] matrix, int from, int to) {
        //2차원 배열을 선언하고 복사해줍니다.
        int[][] currentMatrix = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++) currentMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        //입력된 출발점과 도착점이 같다면 true를 반환합니다 (재귀 함수의 도착 부분)
        if(from == to) return true;

        // 입력된 출발지점의 1차원 배열을 순회합니다.
        for(int i = 0; i < currentMatrix[from].length; i++) {
            //길이 존재한다면
            if(currentMatrix[from][i] == 1) {
                //해당 루트를 순회했다고 표시합니다( 1 -> 0으로 변경)
                currentMatrix[from][i] = 0;
                //표시된 행렬과, 출발지점을 현재 지점인 i로 변경하여 재귀함수를 실행합니다. 재귀함수가 끝까지 도달하였을때 true를 반환한 경우 true를 반환합니다.
                if(getDirections(currentMatrix, i, to)) return true;
            }
        }
        //길을 찾을수 없는 경우 false를 반환합니다.
        return false;
    }

    public static void main(String[] args) {
        UsingMatrix um = new UsingMatrix();
        boolean result = um.getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );
        System.out.println(result);

        boolean result2 = um.getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println(result2); // false
    }

}
// 0. 2차원 배열을 "깊은" 복사하기위해서, copyOf()를 사용했다.
// 1. 그래프에서 값을 경유한 상태를 해당 행렬의 값을 수정하여 나타낼 수 있다.
// 2. 재귀함수를 조건문 속에 넣어 원하는 경우에만 return 할 수 있다. 위 코드에서는 false가 나온 경우, return 없이 지나가도록 하고 있다.
// 3. 간선이 없는 경우는 1차열 배열을 순회할때 아무일도 일어나지 않고, 결국 false를 return한다.

// 참고1: 무방향의 경우, 행렬을 기준으로 대칭하는 부분에 같은 값이 들어가 있다.



// 예시
// gD(출발점, 도착점)
// gD(0, 2) -> gD(1,2) -> gD(2,2)
//   true   <-  true   <-  if(true) true
// ---------------------------------------------
// 예시2
// gD(1, 4) -> gD(3, 4) -> gD(1, 4)
//                      -> gD(2, 4) -> gd(1, 4)
// gD(1, 4)로 돌아오면 1출발점 배열은 모두 0인 요소만 가지고있다. return false;
// if(false) 로 아무 동작 하지않고 24번줄의 false를 return한다.