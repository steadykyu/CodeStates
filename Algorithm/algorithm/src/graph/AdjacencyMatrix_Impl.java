package graph;

import java.util.Arrays;

public class AdjacencyMatrix_Impl {
    private int[][] graph;

    public void setGraph(int size) {
        graph = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                graph[i][j] = 0;
            }
        }
    }
    public int[][] getGraph() {
        return graph;
    }
    public void addEdge(int from, int to) {
        if(from >= graph.length || to >= graph.length) return;
        graph[from][to] = 1;
    }

    public boolean hasEdge(int from, int to) {
        if(from >= graph.length || to >= graph.length) return false; // 정점 위치가 이상한 경우
        else if(graph[from][to] == 1) return true;    // 1 이므로, 인접 행렬에 간선이 존재하는 경우
        else return false;
    }

    public void removeEdge(int from, int to) {
        if(from >= graph.length || to >= graph.length) return;
        graph[from][to] = 0;                          // 0이므로, 인접 행렬에 간선이 존재 하지 않음.
    }


    // 메인함수
    public static void main(String[] args) {
        AdjacencyMatrix_Impl adjMatrix = new AdjacencyMatrix_Impl();
        adjMatrix.setGraph(3);
        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
/*
							TO
		 	  	 0  1  2
		  	0	[0, 0, 0],
	FROM 	1	[0, 0, 0],
		  	2	[0, 0, 0]
*/
        // 간선 정보 추가
        System.out.println("-".repeat(50));
        System.out.println("간선 정보 추가");
        adjMatrix.addEdge(0, 1);
        adjMatrix.addEdge(0, 2);
        adjMatrix.addEdge(1, 2);
        // 확인
        boolean zeroToOneEdgeExists = adjMatrix.hasEdge(0, 1);
        System.out.println(zeroToOneEdgeExists); // true
        boolean zeroToTwoEdgeExists = adjMatrix.hasEdge(0, 2);
        System.out.println(zeroToTwoEdgeExists); // true
        boolean oneToZeroEdgeExists = adjMatrix.hasEdge(1, 0);
        System.out.println(oneToZeroEdgeExists); // false

        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
/*
							TO
		 	  	 0  1  2
		  	0	[0, 1, 1],
	FROM 	1	[0, 0, 1],
		  	2	[0, 0, 0]
*/
        // 간선 정보 지우기
        System.out.println("-".repeat(50));
        System.out.println("간선 정보 지우기");
        adjMatrix.removeEdge(1, 2);
        adjMatrix.removeEdge(0, 2);
        boolean oneToTwoEdgeExists = adjMatrix.hasEdge(1, 2);
        System.out.println(oneToTwoEdgeExists); // false
        zeroToTwoEdgeExists = adjMatrix.hasEdge(0, 2);
        System.out.println(zeroToTwoEdgeExists); // false

        System.out.println(Arrays.deepToString(adjMatrix.getGraph()));
/*
							TO
		 	  	 0  1  2
		  	0	[0, 1, 0],
	FROM 	1	[0, 0, 0],
		  	2	[0, 0, 0]
*/
    }
}
