package org.research.starter.basic.sbpaeng.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2Solution1PSB {
    public int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i=0; i<bridge_length; i++){
            bridge.offer(0);
        }
        Queue<Integer> garage = new LinkedList<>();
        for (int truck : truck_weights){
            garage.offer(truck);
        }
        int end = 0;
        int onBridge = 0;
        while (end < truck_weights.length){
            if(!garage.isEmpty()&&onBridge+garage.peek()<=weight){
                onBridge+=garage.peek();
                bridge.offer(garage.poll());
            }else {
                if(garage.isEmpty()){
                    onBridge-=bridge.peek();
                }else {
                    onBridge-=garage.peek();
                }
                bridge.offer(0);
            }
            if(bridge.peek()>0){
                onBridge-=bridge.peek();
                end++;
            }
            bridge.poll();
            answer++;
        }
        return answer;
    }
}