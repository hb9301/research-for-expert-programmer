package org.research.starter.basic.shcho;

import java.util.*;
import java.util.function.Predicate;

public class ArraySolution4CSH {

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
            if( bridge.poll() != 0) {
                truck_count++;
            }
            weight_sum = bridge.stream().mapToInt(i -> i).sum();
            if( trucks.size() != 0 && (weight >= weight_sum + trucks.peek())){
                bridge.add(trucks.poll());
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

        ArraySolution4CSH arraySolution4CSH = new ArraySolution4CSH();
        System.out.println(arraySolution4CSH.solution(bridge_length,weight,truck_weights));
    }

}