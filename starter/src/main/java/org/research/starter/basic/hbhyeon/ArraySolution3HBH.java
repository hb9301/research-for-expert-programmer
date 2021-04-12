package org.research.starter.basic.hbhyeon;

import java.util.*;

public class ArraySolution3HBH {

    public String[] solution1(String[] strings, int n) {
        String[] answer = {};

//        너무 소름돋는 생각의 코드.....배워야함....
//        answer = new String[strings.length];
//        for(int i = 0; i < strings.length; i++){
//            strings[i] = strings[i].charAt(n) + strings[i];
//        }
//
//        Arrays.sort(strings);
//
//        for(int i = 0; i < strings.length; i++) {
//            answer[i] = strings[i].substring(1,strings[i].length());
//        }

        answer = new String[strings.length];
        //1차 사전순 정렬
        Arrays.sort(strings);

        String[] sort = new String[strings.length];
        Map<String, String> map = new HashMap<>();

        for(int i=0; i<strings.length; i++){
            String sp = strings[i].substring(n,n+1);
            sort[i] = sp;
            if(map.get(sp) != null){
                map.put(sp, map.get(sp) + "," + strings[i]);
            } else {
                map.put(sp, strings[i]);
            }

        }

        //2차 단어정렬
        Arrays.sort(sort);

        for(int i=0; i<sort.length; i++){
            if(map.get(sort[i]).split(",").length > 1){
                answer[i] = map.get(sort[i]).split(",")[0];
                map.put(sort[i], map.get(sort[i]).substring(answer[i].length()+1, map.get(sort[i]).length()));
            }else{
                answer[i] = map.get(sort[i]);
            }
        }


        return answer;
    }


    public int solution2(int[] nums) {
        int answer = 0;

        int half = nums.length/2;

        Set<Integer> set = new HashSet<>();


        set.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(set.size() == half){
                break;
            }
            if(nums[i-1] != nums[i])
                set.add(nums[i]);
        }

        answer = set.size();

        return answer;
    }

}
