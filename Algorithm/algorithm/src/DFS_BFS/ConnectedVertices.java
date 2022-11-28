package DFS_BFS;
// 12. 연결된 정점들 문제입니다.

import java.util.LinkedList;
import java.util.Queue;

class ConnectedVertices {

    public int connectedVertices(int[][] edges) {

        int max = -1;
        // edges 속 최대 Vertax 크기 구하기
        for(int i =0; i<edges.length; i++){
            for(int j=0; j<edges[i].length; j++){
                max = Math.max(max, edges[i][j]);
            }
        }


        // 인접 행렬 생성
        // edges 요소 최대 크기 + 1 -> 인접행렬 크기
        int[][] adjArray = new int[max+1][max+1];
        // for edges : 무향간선 추가
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            adjArray[from][to] = 1;
            adjArray[to][from] = 1;
        }
//        System.out.println(Arrays.deepToString(adjArray));
        //방문한 버택스를 담은 배열을 선업합니다. boolean 기본값 = false 를 가지고 있음.
        boolean[] visited = new boolean[max+1];
        // 컴포넌트가 몇 개인지 카운트할 변수를 선언합니다.
        int count = 0;
        // 방문 여부를 체크한 배열을 모두 순회합니다.
        for(int vertex = 0; vertex < visited.length; vertex++){
            //만약 방문하지 않았다면
            if(!visited[vertex]){
                //컴포넌트를 늘려주고
                System.out.println(count);
                count++;
                // 그래프와 버텍스, 방문했는지 확인할 visited를 bfs 혹은 dfs를 사용하여 변수에 담습니다.
                visited = bfs_array(adjArray, vertex, visited); // bfs 탐색 후 방문한 vertex 정보를 담은 배열 return
            }
        }
        return count;
    }

    // queue 모양상태 : (0 -> 1 -> "") / (2 -> 3 -> 4 5 -> 5 -> "")
    // 한번에 4와 5 vertex를 큐에 넣는 너비탐색 특징이 보인다.
    private boolean[] bfs_array(int[][] adjArray, int vertex, boolean[] visited ) {
        //bfs의 경우 큐를 사용합니다.
        Queue<Integer> queue = new LinkedList<>();
        //시작지점을 큐에 넣어주고, 해당 버택스의 방문 여부를 변경합니다.
        queue.add(vertex);
        visited[vertex]=true;
        //큐에 더이상 방문할 요소가 없을 경우까지 반복합니다.
        while(!queue.isEmpty()){
            //현재 위치를 큐에서 꺼내온 후
            int cur = queue.poll(); //0
            //전체 배열에서 현재 버택스의 행만 확인합니다.
            for(int i = 0; i < adjArray[cur].length; i++) {
                //길이 존재하고, 아직 방문하지 않았을 경우
                if (adjArray[cur][i] == 1 && !visited[i]) { //i ==1
                    //큐에 해당 버택스의 위치를 넣어주어 방문을 예약한다.
                    queue.add(i);
                    //방문여부를 체크합니다.
                    visited[i] = true;
                }
            }
        }
    //이어진 모든 길을 순회한 후 방문여부가 체크된 배열을 반환합니다.
        return visited;
    }

    //dfs(0) -> dfs(1) / dfs(2) -> dfs(3) -> dfs(4) -> dfs(5)
    // visited[] 0-1 index 순으로 true를 넣고 최종 배열을 재귀적으로 반환
    // visited[] 2-3-4-5 index 순으로 true를 넣고 최종 배열을 재귀적으로 반환
    private boolean[] dfs_array(int[][] adjArray, int vertex, boolean[] visited ) {
        //현재 버택스의 방문여부를 체크합니다.
        visited[vertex] = true;
        //해당 버택스의 행을 순회합니다.
        for(int i=0; i < adjArray[vertex].length; i++) {
            //만약 길이 존재하고, 방문하지 않았다면
            if(adjArray[vertex][i]==1 && !visited[vertex]) {
                //재귀를 사용하여 이어진 길부터 탐색을 다시 시작합니다.
                dfs_array(adjArray,i,visited); // 딱히 재귀한 값을 이용하지는 않고, visited 배열에서 방문여부만 바꿈.
            }
        }
        //이어진 모든 길을 순회한 후 방문여부가 체크된 배열을 반환합니다.
        return visited;
    }

    public static void main(String[] args) {
        ConnectedVertices cv = new ConnectedVertices();
        int result = cv.connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {4, 5},
        });
        System.out.println(result); // 3

        int result2 = cv.connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5},
        });
        System.out.println(result2); // 2
    }
}
//어려우면 해당 아래 그림을 이용하자
// [
//   [0,1,0,0,0,0]
//   [1,0,0,0,0,0]
//   [0,0,0,1,0,0]
//   [0,0,1,0,0,0]
//   [0,0,0,0,0,1]
//   [0,0,0,0,1,0]
// ]

// visited = [false,false,false,false,false,false]