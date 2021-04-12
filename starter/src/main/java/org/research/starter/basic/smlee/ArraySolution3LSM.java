package org.research.starter.basic.smlee;

import java.util.*;

public class ArraySolution3LSM {

    /**
     * 1번문제 (https://programmers.co.kr/learn/courses/30/lessons/12915)
     * 문자 내 마음대로 정렬하기
     */
    public String[] solution(String[] strings, int n) {
        // 정렬
        Arrays.sort(strings, new Comparator<String>(){
           @Override
           public int compare(String o1, String o2) {
               // 무한루프 돌면서 비교하기
               for(int i=0; true; i++) {
                   if (o1.charAt(n) > o2.charAt(n)) {
                       return 1;
                   } else if (o1.charAt(n) < o2.charAt(n)) {
                       return -1;
                   } else {
                       return (o1.compareTo(o2));
                   }
               }
           }
       });
        
        return strings;
    }

    /**
     * 2번문제(https://programmers.co.kr/learn/courses/30/lessons/1845)
     * 폰캣몬
     */
    public int solution(int[] nums) {
        int answer = 0;

        // 중복제거
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int noDupPonket = set.size();

        // n/2마리 선택
        int n2Ponket = nums.length / 2;

        // 가장 많은 종류의 폰켓몬을 고르기
        // 둘중에 최소값이 정답.
        if(noDupPonket > n2Ponket)
            answer = n2Ponket;
        else{
            answer = noDupPonket;
        }

        return answer;
    }

}