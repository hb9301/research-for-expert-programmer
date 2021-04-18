package org.research.starter.basic.sbpaeng.level1;


import java.util.ArrayList;

public class ArraySolution3PSB {

    public String[] solution(String[] strings, int n) {
        /* 1.
         * ["sun", "bed", "car"]	    1	["car", "bed", "sun"]
         * ["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
         */

        //compareTo : 사전순 정렬
        int i = 0;
        while (i<strings.length){
            String a = strings[i];
            String b = strings[i+1];

            //a < b : -1
            //a > b : 1 -> swap
            //a = b : 0
            if(a.compareTo(b)>0){
                strings[i+1] = a;
                strings[i] = b;
                i = 0;
            }else {
                i++;
            }
            if(i+1==strings.length){
                break;
            }
        }

        //알파벳 순차 비교
        i = 0;
        while (i<strings.length) {
            String a = strings[i];
            String b = strings[i+1];

            //a 가 b 보다 크면 스왑
            if(a.charAt(n)>b.charAt(n)){
                strings[i+1] = a;
                strings[i] = b;
                i = 0;
            }else {
                i++;
            }

            if(i+1==strings.length){
                break;
            }
        }

        /*
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n)>o2.charAt(n)){
                    //a 가 b 보다 크면 스왑
                    return 1;
                }else if(o1.charAt(n)<o2.charAt(n)){
                    //a 가 b 보다 작으면 냅둬
                    return -1;
                }else{
                    //a < b : -1
                    //a > b : 1 -> swap
                    //a = b : 0
                    return o1.compareTo(o2);
                }
            }
        });
        */

        return strings;
    }

    public  int solution2(int[] nums){
        int result = 0;
        int max = 0;
        max = nums.length/2;

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums){
            if(!list.contains(num)){
                list.add(num);
            }
        }

         if(list.size()>max){
             result = max;
         }else{
             result = list.size();
         }


        return result;
    }

}
