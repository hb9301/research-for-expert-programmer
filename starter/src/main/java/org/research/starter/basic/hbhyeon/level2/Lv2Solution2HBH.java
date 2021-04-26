package org.research.starter.basic.hbhyeon.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lv2Solution2HBH {

    // 각 종류별 조합으로 계산
    // A 종류에서 0개 or 1개, B 종류에서 0개 or 1개 ....
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothType = new HashMap<>();

        // java8 부터
        // merge(key, value, function(key, value) -> logic)
        for(String[] cloth : clothes){
            clothType.merge(cloth[1], 1, (a, b) -> clothType.get(cloth[1]) + b);
        }

        // java7 까지 for문
//        for(String[] cloth : clothes){
//            if(clothType.get(cloth[1]) != null)
//                clothType.put(cloth[1], clothType.get(cloth[1]) + 1);
//            else
//                clothType.put(cloth[1], 1);
//        }

        for(String key : clothType.keySet()){
            // 옷 종류별 1개를 고를 수 있는 경우의 수 + 1(하나도 안 고를 경우)
            answer *= clothType.get(key) + 1;
        }

        // 옷을 하나도 안고를 경우는 뺀다
        answer--;

        return answer;
    }


    // 아래까지는 전체를 놓고 조합을 하려했던 실수....

//    Map<String, String> clothMap = new HashMap<>();
//    Map<String, Boolean> selectedType = new HashMap<>();

//    public int solution(String[][] clothes) {
//        int answer = 0;
//
//        Map<String, String> clothTypeMap = new HashMap<>();
//
//        // 1개만 입을 경우
//        answer += clothes.length;
//
//        for (String[] clothe : clothes) {
//            if(clothTypeMap.get(clothe[1]) == null) {
//                clothTypeMap.put(clothe[1], clothe[0]);
//                selectedType.put(clothe[1], false);
//            }
//        }
//
//
//        for(int i = 0; i < clothes.length; i++) {
//            // 시작하는 옷의 종류 true
//            selectedType.put(clothes[i][1], true);
//            getConv(clothes, i, 1, selectedType.size(), answer);
//            selectedType.put(clothes[i][1], false);
//        }
//
//        return answer;
//    }
//
//    public void getConv(String[][] clothes, int start, int chooseNum, int maxPick, int answer){
//        if(chooseNum == maxPick)
//            return;
//
//        if(chooseNum < clothes.length - 1){
//            getConv(clothes, start, chooseNum + 1, maxPick, answer);
//        }
//
//        int pick = 0;
//        int allSelect = 0;
//        while(allSelect < clothes.length - start - 1){
//            for(int i = start; i < clothes.length; i++){
//                if(!selectedType.get(clothes[i][1]) && pick < chooseNum){
//                    pick++;
//                    selectedType.put(clothes[i][1], true);
//                } else if(!selectedType.get(clothes[i][1]) && pick == chooseNum){
//                    pick = 0;
//                    answer++;
//                }
//            }
//        }
//    }

//    public int solution(String[][] clothes) {
//        int answer = 0;
//
//        Map<String, String> clothMap = new HashMap<String, String>();
//
//        for(int i = 0; i < clothes.length; i++){
//            if(clothMap.get(clothes[i][1]) == null)
//                clothMap.put(clothes[i][1], clothes[i][0]);
//            else
//                clothMap.put(clothes[i][1], clothMap.get(clothes[i][1]) + "," + clothes[i][0]);
//        }
//
//        // 종류별 1개씩만 입을 경우
//        answer += clothes.length;
//
//        int n = clothMap.size();
//        int conv = 0;
//
//
//        for (int i = 2; i <= n; i++) {
//            for(String key : clothMap.keySet()){
//                String[] eachCloth = clothMap.get(key).split(",");
//                if(eachCloth.length > 1){
//                    // 종류별 조합에 따른 같은 종류 = 동일한 종류가 포함된 조합 수 * 동일한 종류 수
//                    // 동일 종류가 있는 조합 = (n - 1)! / (r - 1)!( (n-1) - (r-1) )!
//                    conv += ( fact(n - 1) / (fact(i) * fact((n - 1) - i)) ) * (eachCloth.length - 1);
//                }else{
//                    // 종류별 조합 = n! / r!(n-r)!
//                    conv += ( fact(n) / (fact(i) * fact(n-i)) );
//                }
//            }
//        }
//
//        return answer;
//    }

//    public int fact(int n){
//        if(n == 0)
//            return 1;
//
//        if( n <= 1)
//            return n;
//        else
//            return fact(n-1) * n;
//    }

}
