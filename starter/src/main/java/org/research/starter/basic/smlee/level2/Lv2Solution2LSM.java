package org.research.starter.basic.smlee.level2;

import java.util.HashMap;

public class Lv2Solution2LSM {

    /**
     * 5번문제[2레벨 2번] (https://programmers.co.kr/learn/courses/30/lessons/42578)
     * 위장 (Hash)
     */
    public int solution(String[][] clothes) {
        // 해쉬
        HashMap<String, Integer> map = new HashMap<>();
        // 계산을 위해서 1로 시작.
        int answer = 1;

        // 의상의 종류에 따른 길이 구하기
        for(int i = 0; i < clothes.length; i++){
            // 맵에 해당 의상종류가 있는지 체크하여 없으면 키 : 의상종류 / 벨류 : 의상종류개수 추가
            if(!map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], 1);
            else // 해당 의상종류가 있다면 의상종류개수 +1
                map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
        }

        // 경우의 수 구하기((n+1) * (n+1) ... ) 입거나 안입거나 2가지의 경우가 있기 때문에 +1
        for(String key : map.keySet())
            answer *= (map.get(key) + 1);

        // 아무것도 입지 않았을 수도 있으니 마지막에 -1
        return answer - 1;
    }

}