package org.research.starter.basic.jsbae;

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
}
