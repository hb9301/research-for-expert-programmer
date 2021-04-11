package org.research.starter.basic.shcho;

import java.util.*;
import java.util.function.*;

public class ArraySolution3CSH {
    /**
     * Second Programming - Array #3-1
     * https://github.com/hb9301/research-for-expert-programmer/issues/4
     *
     * @param strings
     * @param n
     * @return
     */
    public String[] solution(String[] strings, int n) {

        List<String> list = Arrays.asList(strings);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                while(true){
                    if(o1.charAt(n) > o2.charAt(n)) return 1;
                    else if(o1.charAt(n) < o2.charAt(n)) return -1;
                    else return (o1.compareTo(o2));
                }
            }
        });
        return list.toArray(new String[0]);
    }

    /**
     * Second Programming - Array #3-2
     * https://github.com/hb9301/research-for-expert-programmer/issues/4
     *
     * @param nums
     * @return
     */

    public int solution(int[] nums) {
        int answer = 0;

        int n = nums.length / 2;
        ArrayList<Integer> list = new ArrayList();
        for(int i : nums){
            list.add(i);
        }

        while(n>0){
            if(list.size() == 0) break;
            list.removeIf(new Predicate<Integer>() {
                @Override
                public boolean test(Integer integer) {
                    return (integer.equals(list.get(0)));
                }
            });
            answer++;
            n--;
        }

        return answer;
    }


}