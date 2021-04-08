package org.research.starter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;


@SpringBootTest
public class ResearchApplicationTests {

    @Test
    void contextLoads() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

//        System.out.println(new ArraySolution2HBH().solution(new int[][]{{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
//        System.out.println(Arrays.toString(new ArraySolution2HBH().subSolution(new int[]{4, 3, 1, 2, 5})));


        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }

}
