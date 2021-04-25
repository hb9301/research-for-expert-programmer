package org.research.starter.basic.shcho.level2;

import java.util.*;

public class Lv2Solution2CSH {

    /**
     * 5th Programming - Hash #6
     * https://github.com/hb9301/research-for-expert-programmer/issues/6
     *
     *
     */
    public int solution(String[][] clothes) throws Exception{
        int answer = 0;

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String[] clothe : clothes){
            if(hashMap.containsKey(clothe[1]) == true){
                hashMap.get(clothe[1]).add(clothe[0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(clothe[0]);
                hashMap.put(clothe[1],list);
            }
        }

        for(String key : hashMap.keySet()){
            if(answer == 0){
                answer = hashMap.get(key).size()+1;
            } else {
                answer *= hashMap.get(key).size()+1;
            }
        }
        answer--;

        return answer;
    }

}