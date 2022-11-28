package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueuePrinter {
    public int queuePrinter(int bufferSize, int capacities, int[] documents) {

        int count = 0;

        // 인쇄 환경을 담을 큐를 선언합니다. 큐는 추상 인터페이스, LinkedList, 우선순위큐로 구현 할 수 있습니다.
        Queue<Integer> queue = new LinkedList<>();

        //선언한 큐를 bufferSize 만큼 0으로 채워줍니다.
        for(int i=1; i <= bufferSize; i++){
            queue.add(0);
        }

        // 첫 시작으로 0번 문서를 넣어줍니다. 이후 결과 1 증가.
        // 맨처음 값을 초기화합시다.
        // 문서 documnets 도 한개 줄여줍니다.
        queue.poll();
        queue.add(documents[0]);
        count++;
        documents = Arrays.copyOfRange(documents, 1, documents.length);

        // 반복을 시작합니다.
        // 더이상 문서가 없을 경우 && 대기열이 존재하지 않는 경우 멈춰야 합니다.
        while(documents.length!=0 || (queue.stream().reduce(0,Integer::sum) != 0)) {
            if (documents.length != 0) {//대기중인 문서가 남은 경우
                int sum = queue.stream().reduce(0, Integer::sum) + documents[0];
                //(작업중인 대기열 요소의 합과, 남은 문서중 가장 처음의 크기) 의 합이 capacities 보다 큰 경우
                if (sum > capacities) {
                    // 대기열 맨앞 부분 제거 후
                    // (작업중인 대기열 요소의 합과, 남은 문서중 가장 처음의 크기) 의 합
                    queue.poll();
                    sum = queue.stream().reduce(0, Integer::sum) + documents[0];

                    if( sum <= capacities){ //남은 대기열에 첫번째 문서를 포함했을때(문서를 제거하며), 수용이 가능하다면,
                        queue.add(documents[0]);
                        documents = Arrays.copyOfRange(documents,1,documents.length); // 문서를 하나 지워준다.
                        count++;
                    } else{ //남은 대기열에 첫번째 문서를 포함했을때(문서를 제거하며), 수용이 불가능하다면 ( if(sum > capacities) )
                        queue.add(0);
                        count++;
                    }
                }
                // (작업중인 문서와, 남은 문서중 가장 처음의 크기) 의 합이 capacities 보다 작은 경우
                else {
                    queue.poll();
                    queue.add(documents[0]);
                    documents = Arrays.copyOfRange(documents,1,documents.length); // 문서를 하나 지워준다.
                    count++;
                }
            } else {
                //대기중인 문서가 없을 경우
                queue.poll();
                queue.add(0);
                count++;
            }
        }
        return count;
    }
// 예시가 두개라 나누어할 조건부분이 잘 보이지 않는데, 세개로 진행하면 더 잘 보인다.
// 각 과정을 하나하나 구현하려고 애써야 해결 방안이 보인다.
// Queue에 0을 넣으면서, 큐를 일정한 크기로 유지 할 수 있다.

    public static void main(String[] args) {
        QueuePrinter qp = new QueuePrinter();
        System.out.println(qp.queuePrinter(2, 10 , new int[]{7,4,5,6}));
    }
}



// 내풀이(딱히 차이없는듯)
//    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
//        Queue<Integer> queue = new LinkedList();
//        int time=0;
//        // bufferSize 만큼 queue를 0의 값으로 채워준다.
//        for(int i=1; i<=bufferSize; i++){
//            queue.add(0);
//        }
//
//        // 초기화
//        queue.poll();
//        queue.add(documents[0]); // 07
//        time++;
//        documents = Arrays.copyOfRange(documents,1,documents.length);
//
//        //탈출 조건 : documents 비어있음 && queue 비어있음
//        while(documents.length != 0 || !queue.isEmpty()){
//            if(documents.length != 0){ // documents가 남아 있을 때
//                // 예시 7 4 5 6
//                // queue의 크기를 유지해주기 위해 poll()과 동시에 add가 일어나야한다.
//                queue.poll();
//                // if(poll() 한 queue의 요소의 합 + 문서에서 오는 값 <= capacities) -> queue에 문서를 넣는다.
//                if(queue.stream().mapToInt(x->x).sum() + documents[0] <= capacities){
//                    queue.add(documents[0]);
//                    documents = Arrays.copyOfRange(documents,1,documents.length);
//                    time++;
//                } else{ // if(poll() 한 queue의 요소의 합 + 문서에서 오는 값 > capacities) -> queue에 0을 넣는다.
//                    queue.add(0);
//                    time++;
//                }
//            }
//            else{ // documents가 남아 있지 않을 때
//                time += bufferSize;
//                queue.clear();
//            }
//        }
//        return time;
//    }