package org.research.starter.basic.sbpaeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArraySolution2PSB {

    public int solution(int[][] board, int[] moves) {
        //board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        //moves = new int[]{1,5,3,5,1,2,1,4};
        //4,3,1,1,3,2,4

        int result = 0;
        ArrayList<Integer> basket = new ArrayList();

        for (int i=0;i<moves.length;i++){
            int ball = move(board,moves[i]-1);
            if(ball>0){
                basket.add(ball);
                result += kill(basket);
            }
        }
        System.out.println(result);
        return result;
    }

    public int move(int[][] board, int move){
        int ball = 0;
        for(int j=0;j<board.length;j++){
            if(board[j][move]>0){
                ball = board[j][move];
                board[j][move] = 0;
                return ball;
            }
        }
        return 0;
    }

    public int kill(ArrayList<Integer> basket){
        int i =0;
        int result = 0;
        while(basket.size() > 1){
            if(basket.get(i) == basket.get(i+1)){
                basket.remove(i+1);
                basket.remove(i);
                i = 0;
                result += 2;
            } else {
                i++;
                if(i+1==basket.size()){
                    break;
                }
            }
        }
        return result;
    }

    public int[] subSolution(int[] arr){
        if(arr.length == 1){
            return new int[] {-1};
        }else{
            Arrays.sort(arr);
            int[] result = new int[arr.length-1];
            for (int i=1;i<arr.length;i++){
                result[i-1]=arr[i];
            }
            return result;
        }
    }
}
