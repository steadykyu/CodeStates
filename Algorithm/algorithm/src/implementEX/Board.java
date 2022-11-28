package implementEX;

import java.util.HashMap;

public class Board {

    public Integer boardGame(int[][] board, String operation) {

        // 현재 보드의 위치
        int x =0; int y=0;
        int n = board.length;

        // 상 하 좌 우 값에 해당하는 방향 값을 가진 Map을 만든다.
        HashMap<String, int[]> hashMap = new HashMap<>();
        hashMap.put("U", new int[]{0,-1});
        hashMap.put("D", new int[]{0,1});
        hashMap.put("L", new int[]{-1,0});
        hashMap.put("R", new int[]{1,0});


        String[] operationArr = operation.split("");

        int res = 0; // 보드속 포인트
        for(int i=0; i < operationArr.length; i++) {
            String dir = operationArr[i];
//            System.out.println("x = "+ x + " , y=" +y + ", res = "+ res);
            int dx = hashMap.get(dir)[0];
            int dy = hashMap.get(dir)[1];

            // 포인트를 이동시킨다.
            x = x + dx;
            y = y + dy;
            // 이동한 점이 유효한지 검사한다.
            if (!isVaild(x, y, n)) return null;
            res += board[y][x];
        }
        return res;
    }

    boolean isVaild(int x, int y, int N){
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public static void main(String[] args) {
        Board board = new Board();

        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = board.boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int output3 = board.boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }
}
