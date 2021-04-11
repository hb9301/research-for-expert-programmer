package org.research.starter.basic.shcho;

import java.util.*;

public class ArraySolution3CSH {
    /**
     * Second Programming - Array #3
     * https://github.com/hb9301/research-for-expert-programmer/issues/3
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
}