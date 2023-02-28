package graph;

import java.util.Arrays;

public class CreateInjectMatrix {
    public int[][] createMatrix(int[][] edges) {
        //edges - from ,to ,방향성

        int size = -1;
        // edges의 가장 큰 정점+1 = 인접행렬의 크기
        for(int[] row : edges){
            for(int col : row){
                size = (int)Math.max(col,size); // 3
            }
        }

        // 0 ~ size개의 정점을 가진 인접행렬
        int[][] graph = new int[size+1][size+1];
        // for edges
        int from;
        int to;
        int direction;// 방향성 표시
        for(int[] edge : edges){ // row
            from = edge[0];
            to = edge[1];
            direction = edge[2];
            // 0(방향) 일 경우
            if(edge[2]==0){
                graph[from][to] = 1;
            }else if(edge[2]==1){ // 1(무방향) 일 경우
                graph[from][to] = 1;
                graph[to][from] = 1;
            }else{
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        CreateInjectMatrix cim = new CreateInjectMatrix();
        int[][] output1 = cim.createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });

        System.out.println(Arrays.deepToString(output1));
    }
}
