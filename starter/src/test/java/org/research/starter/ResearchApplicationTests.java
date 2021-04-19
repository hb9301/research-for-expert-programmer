package org.research.starter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


@SpringBootTest
public class ResearchApplicationTests {

    private final ArrayList<String> classNameList = new ArrayList<>(Arrays.asList("HBH", "BJS", "PSB", "CSH", "LSM"));
    private final HashMap<String, String> packageMap = new HashMap<String, String>(){{
        put("HBH", "hbhyeon");
        put("BJS", "jsbae");
        put("PSB", "sbpaeng");
        put("CSH", "shcho");
        put("LSM", "smlee");
    }};
    private final String level = "level1";

    // 테스트마다 변수는 그때그때 지정
    private final Class<?>[] paramList = new Class<?>[]{Array.newInstance(int.class, 5).getClass(), int.class};

    @Test
    void randomStartTest() {

        String commonClass = "ArraySolution1";
        Collections.shuffle(classNameList);

        StopWatch stopWatch = new StopWatch();

        for(String className : classNameList) {
            stopWatch.start();

            try {
                Class<?> cls = Class.forName("org.research.starter.basic." + packageMap.get(className) + "." + level + "." + commonClass + className);
                Constructor<?> constructor = cls.getConstructor();
                Object testClass = constructor.newInstance();
                Method method = cls.getMethod("solution", paramList);

                // 테스트마다 변수는 그때그때 지정
                System.out.println(method.invoke(testClass, new int[]{1,3,2,5,4}, 9));
            } catch (Exception e){
                e.printStackTrace();
            }

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }

    }

}
