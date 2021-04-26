package org.research.starter.basic.smlee.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2Solution1LSM {

    /**
     * 4번문제[2레벨 1번] (https://programmers.co.kr/learn/courses/30/lessons/42583)
     * 다리를 지나는 트럭(Stack / Queue)
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        // 대기트럭 Q
        Queue<Integer> waitT = new LinkedList<>();
        // 다리를 건너는 트럭 Q
        Queue<Integer> goingT = new LinkedList<>();
        // 다리를 건너는 트럭 최종무게
        int maxWeight = 0;
        // 트럭
        int nextNum = 0;

        // 대기트럭 큐에 담기
        for (int truck : truck_weights){
            waitT.add(truck);
        }

        while(true){
            // 마지막 트럭이 올라갈때 중지.
            if(nextNum == truck_weights.length)
                break;

            // 다리를 지난 트럭 이 발생했으니 최대무게 감소.
            if(goingT.size() == bridge_length){
                maxWeight -= goingT.poll();
            // 현재 다리의 올라가 있는 트럭무게  + 다음 트럭무게 > 견뎌야 하는 다리 무게보다 크면 한칸 전진.
            }else if(maxWeight + waitT.peek() > weight){
                goingT.add(0);
                answer++;
            }else{
            // 위에 2가지 상황이 아니면 다리의 트럭이 올라간다.
                goingT.add(waitT.peek());
                maxWeight += waitT.poll();
                answer++;
                nextNum++;
            }
        }

        // 마지막 트럭이 올라간 상태에서 중지 + 다리의 길이로 = 모든 트럭이 통과한 시간계산.
        return answer + bridge_length;
    }

}