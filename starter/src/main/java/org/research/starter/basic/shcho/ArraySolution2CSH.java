package com.study.lowlevel.shcho;

import java.util.*;

public class ArraySolution2CSH {
    /**
     * Second Programming - Array #2
     * https://github.com/hb9301/research-for-expert-programmer/issues/2
     *
     * @param board
     * @param move
     * @return
     */
    public int solution(int[][] board, int[] move) {

        ArrayList<Integer> basket = new ArrayList();
        int result = 0;

        for(int i : move){
            //잡아서
            int g = grab(board, i);
            if(g!=0){
                //넣고
                basket.add(g);
                //터트린다
                result += pang(basket);
            }
        }
        return result;
    }

    /**
     * 인형을 바구니로 잡는다
     * @param board
     * @param move
     * @return
     */
    int grab(int[][] board, int move){

        for(int[] col : board){
            if(col[move-1] != 0){
                int result = col[move-1];
                col[move-1] = 0;
                return result;
            }
        }
        return 0;
    }

    /**
     * 바구니의 인형이 터지는지 체크
     * @param basket
     * @return
     */
    int pang(ArrayList<Integer> basket){
        int i=0;
        int result=0;

        while(basket.size() > 1){   //한개만 있다면 체크하지않음
            if(basket.get(i) == basket.get(i+1)){   //현재 바구니와 다음바구니 비교
                basket.remove(i+1);
                basket.remove(i);
                i=0;    //다시 처음부터 체크
                result+=2;
            } else {
                i++;
                if(i+1==basket.size()) break;   //바구니 끝-1 까지 인덱스가 갔다면 종료
            }
        }
        return result;
    }

    /**
     * sub 문제
     * @return
     */
    public int[] sub(int[] arr){
        if(arr.length == 1) return new int[] {-1};

        ArrayList<Integer> list = new ArrayList();
        int stored = 0;
        for(int i : arr){
            list.add(i);
        }
        int idx=0;
        while(idx<list.size()-1){
            if(stored < arr[idx]) stored = idx;
            idx++;
        }
        list.remove(idx);

        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,5,5,0,1},{4,2,4,4,2},{3,5,1,3,1},};
        int[] move = {1,5,3,5,1,2,1,4};

        int[] arr = {4,3,2,1};

        ArraySolution2CSH arraySolution2CSH = new ArraySolution2CSH();
        System.out.println(arraySolution2CSH.solution(board,move));
        System.out.println(Arrays.toString(arraySolution2CSH.sub(arr)));
    }
}
