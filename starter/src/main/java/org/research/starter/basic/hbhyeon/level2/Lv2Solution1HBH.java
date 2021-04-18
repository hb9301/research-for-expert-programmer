package org.research.starter.basic.hbhyeon.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2Solution1HBH {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> time = new LinkedList<>();

        int pass = 0;
        int onTime = 1;
        int weightOnbridge = 0;
        int next = 0;
        while(pass < truck_weights.length){

            if(next < truck_weights.length && (weightOnbridge + truck_weights[next] <= weight)){
                time.add(onTime);
                weightOnbridge += truck_weights[next];
                next++;
                onTime++;
            } else {
                answer = time.poll() + bridge_length;
                onTime = Math.max(onTime,answer);
                weightOnbridge = weightOnbridge - truck_weights[pass];
                pass++;
            }

        }

        return answer;
    }

}
