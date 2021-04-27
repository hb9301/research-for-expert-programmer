package org.research.starter.basic.sbpaeng.level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Lv2Solution2PSB {
    public int solution(String[][] clothes) {
        Map<String, Integer> kind = new HashMap<>();

        //종류별로 몇개 있나
        for (int i = 0; i < clothes.length; i++) {
            if(!kind.containsKey(clothes[i][1])){
                kind.put(clothes[i][1], 1);
            }else {
                kind.put(clothes[i][1], kind.get(clothes[i][1])+1);
            }
        }

        //경우의수 계산을 위해 1
        int answer = 1;
        //경우의수
        for(String key : kind.keySet()){
            answer *= (kind.get(key) + 1);
        }

        //아무것도 입지 않은 경우 제외 (-1)
        return answer-1;
    }
}