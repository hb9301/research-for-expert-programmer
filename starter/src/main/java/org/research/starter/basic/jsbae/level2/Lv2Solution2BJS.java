package org.research.starter.basic.jsbae.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv2Solution2BJS {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, List<String>> map = new HashMap();
        String type = "";

        for(String[] set1 : clothes){ // 각 타입별로 항목 정리
            List<String> valueList = new ArrayList<>();
            type = set1[1];
            if(map.get(type) != null){ // 해당 타입 존재
                valueList = map.get(type);
            }
            valueList.add(set1[0]);
            map.put(type, valueList);
        }

        // aC1 * bC1 * ...
        for(Map.Entry<String,List<String>> ent : map.entrySet()){
            answer *= (ent.getValue().size() + 1); // 항목 갯수 + 착용 안 한 경우(1)
        }

        return answer - 1 ; // 아무것도 안 입은 경우 제외
    }
}
