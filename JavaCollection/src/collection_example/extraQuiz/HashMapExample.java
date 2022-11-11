package collection_example.extraQuiz;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        System.out.println("----- 깜짝 위생 검사 -----");

        hashMap.put("조영현", 2);
        hashMap.put("김다빈", 5);
        hashMap.put("박무승", 3);
        hashMap.put("안병옥", 10);
        hashMap.put("강지은", 1);
        hashMap.put("조민기", 5);
        hashMap.put("이근휘", 0);

        // 목록 순회
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entrySet.iterator(); // Iterater<읽어올 요소 타입> 도 제너릭이 필요하다!

        while (iterator1.hasNext()) {
            Map.Entry entry = iterator1.next();

            System.out.println("이름 : " + entry.getKey() + ", 머리 감은 횟수 : " + entry.getValue());
        }

        System.out.println();

        // 참여자 명단 뽑기
        Set<String> keySet = hashMap.keySet();
        System.out.println("조사 참여자 : " + keySet);

        // 평균 구하기
        Collection values = hashMap.values();
        Iterator<Integer> iterator2 = values.iterator();

        int total = 0;

        while (iterator2.hasNext()) {
            int num = iterator2.next();
            total += num;
        }

        System.out.println("평균 : " + (float) total / keySet.size() + "회");

        // 최소값 구하기

        System.out.print("가장 적게 감은 사람 : ");
        iterator1 = entrySet.iterator();

        while (iterator1.hasNext()) {

            Map.Entry entry = iterator1.next();

            if (Collections.min(values) == entry.getValue()) {
                System.out.print(entry.getKey() + " ");
            }
        }

        System.out.println();

    }
}
