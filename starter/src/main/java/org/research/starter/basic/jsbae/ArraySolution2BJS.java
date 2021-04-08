package org.research.starter.basic.jsbae;

import java.util.Arrays;
import java.util.Stack;

public class ArraySolution2BJS {


    public int solution(int[][] board, int[] moves){
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int move : moves){
            for(int i = 0; i < board.length; i++){
                if(board[i][move - 1] != 0){ // 인형을 잡는다.
                    if(stack.size() != 0 && stack.peek() == board[i][move - 1]){ // 같은 아이템
                        stack.pop(); // 마지막 아이템 제거
                        result ++;
                    }else{ //다른 아이템
                        stack.push(board[i][move - 1]);
                        board[i][move - 1] = 0;
                    }
                    break;
                }
            }
        }
        return result * 2;
    }

    // sub
    public int[] solution2(int[] arr){
        if(arr.length == 1)
            return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt(); // min은 항상 존재하기때문에 ifPresent 체크 필요 없음
        return Arrays.stream(arr).filter(n -> n != min).toArray();
    }
}
