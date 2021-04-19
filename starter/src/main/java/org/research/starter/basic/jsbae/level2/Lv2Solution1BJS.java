package org.research.starter.basic.jsbae.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2Solution1BJS {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int nowWeight = 0;
        Queue<Integer> dari = new LinkedList<>();
        for(int truck_w : truck_weights){
            while(true){
                if(dari.isEmpty()){ // 비어있을 때
                    dari.add(truck_w); // 트럭이 들어온다.
                    nowWeight += truck_w;
                    answer ++;
                    break;
                }else{ // 트럭이 있을 때
                    if(bridge_length == dari.size()){// 다리길이와 큐의 길이가 같으니까 트럭 나간다.
                        nowWeight -= dari.poll(); // 트럭이 다리 다 건넜으니까 그 무게만큼 빼기
                    }else if(nowWeight + truck_w <= weight){ // 합이 총 중량보다 적으니까 다음 트럭 하나 들어온다.
                        dari.add(truck_w);
                        nowWeight += truck_w;
                        answer ++;
                        break;
                    }else{ // 트럭 무게 초과니까 기존 트럭만 한 칸 전진한다.
                        dari.add(0);
                        answer ++;
                    }
                }
            }
        }

        return answer  + bridge_length;
    }

}
