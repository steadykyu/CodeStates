package stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrinterByQueue {

    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        Queue<Integer> queue = new LinkedList();
        int time=0;
        // bufferSize 만큼 queue를 0의 값으로 채워준다.
        for(int i=1; i<=bufferSize; i++){
            queue.add(0);
        }

        // 초기화
        queue.poll();
        queue.add(documents[0]); // 07
        time++;
        documents = Arrays.copyOfRange(documents,1,documents.length);

        //탈출 조건 : documents 비어있음 && queue 비어있음
        while(documents.length != 0 || !queue.isEmpty()){
            if(documents.length != 0){ // documents가 남아 있을 때
                // 예시 7 4 5 6
                // queue의 크기를 유지해주기 위해 poll()과 동시에 add가 일어나야한다.
                queue.poll();
                // if(poll() 한 queue의 요소의 합 + 문서에서 오는 값 <= capacities) -> queue에 문서를 넣는다.
                if(queue.stream().mapToInt(x->x).sum() + documents[0] <= capacities){
                    queue.add(documents[0]);
                    documents = Arrays.copyOfRange(documents,1,documents.length);
                    time++;
                } else{ // if(poll() 한 queue의 요소의 합 + 문서에서 오는 값 > capacities) -> queue에 0을 넣는다.
                    queue.add(0);
                    time++;
                }
            }
            else{ // documents가 남아 있지 않을 때
                time += bufferSize;
                queue.clear();
            }
        }
        return time;
    }


    public static void main(String[] args) {
        PrinterByQueue pbq = new PrinterByQueue();

        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5, 6};

        int output = pbq.queuePrinter(bufferSize, capacities, documents);
        System.out.println(output); // 8
    }
}
