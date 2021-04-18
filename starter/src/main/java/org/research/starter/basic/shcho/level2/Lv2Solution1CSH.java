package org.research.starter.basic.shcho.level2;

import java.util.*;

public class Lv2Solution1CSH {

    /**
     * 4th Programming - stack/queue #5
     * https://github.com/hb9301/research-for-expert-programmer/issues/5
     *
     *
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();

        int truck_count = 0;
        int answer = 0;
        int weight_sum = 0;

        for (int i=0; i<bridge_length; i++){
            bridge.add(0);
        }
        for (int i: truck_weights) {
            trucks.add(i);
        }

        while (truck_count < truck_weights.length) {

            weight_sum-=bridge.peek();
            if( bridge.poll() != 0) {
                truck_count++;
            }

            if( trucks.size() != 0 && (weight >= weight_sum + trucks.peek())){
                bridge.add(trucks.peek());
                weight_sum+=trucks.poll();
            } else {
                bridge.add(0);
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {

        int bridge_length=2;
        int weight=10;
        int[] truck_weights = {7, 4, 5, 6};

        Lv2Solution1CSH lv2Solution1CSH = new Lv2Solution1CSH();
        System.out.println(lv2Solution1CSH.solution(bridge_length,weight,truck_weights));
    }

}