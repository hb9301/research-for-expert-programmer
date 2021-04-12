package org.research.starter.basic.jsbae;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySolution3BJS {

    public String[] solution(String[] strings, int n){
        return Arrays.stream(strings).sorted((s1, s2) -> {
            int n1 = s1.charAt(n);
            int n2 = s2.charAt(n);

            if(n1 > n2){
                return 1;
            }else if(n1 < n2){
                return  -1;
            }else{
                return s1.compareTo(s2);
            }
        }).toArray(String[]::new);
    }

    public int solution2(int[] nums){
        Set<Integer> item = new HashSet<>();
        int pickCnt = nums.length/2;
        for(int num : nums){
            item.add(num);
        }
        if(pickCnt >= item.size()){
            return item.size();
        }else{
            return pickCnt;
        }
    }
}
