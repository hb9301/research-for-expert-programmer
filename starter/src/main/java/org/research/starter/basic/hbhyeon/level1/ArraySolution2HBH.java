package org.research.starter.basic.hbhyeon.level1;

import java.util.ArrayList;

public class ArraySolution2HBH {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        ArrayList<Integer> bucket = new ArrayList<>();

        for(int move : moves){
            for(int[] line : board){
                if(line[move-1] != 0){
                    if(bucket.size() > 0 && bucket.get(bucket.size()-1) == line[move-1]) {
                        bucket.remove(bucket.size() - 1);
                        answer+=2;
                    } else
                        bucket.add(line[move-1]);

                    line[move-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public int[] subSolution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        int[] answer = new int[arr.length - 1];
        int min = arr[0];
        for(int findMin : arr){
            if(min > findMin)
                min = findMin;
        }

        int count = 0;

        for(int num : arr){
            if(num != min) {
                answer[count] = num;
                count++;
            }
        }


        return answer;
    }

}
