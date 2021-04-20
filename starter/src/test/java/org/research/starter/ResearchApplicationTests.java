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
    private final String level = "level2";

    // 테스트마다 변수는 그때그때 지정
    private final Class<?>[] paramList = new Class<?>[]{int.class,int.class,Array.newInstance(int.class, 5).getClass()};

    @Test
    void randomStartTest() {

        String commonClass = "Lv2Solution1";
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
                //2,10,new int[]{7,4,5,6}
                //100,100,new int[]{10}
                //100,100,new int[]{10,10,10,10,10,10,10,10,10,10}
                //8000,4000,new int[]{3800,10,15,20,20,20,30,3800,300,200,200,2000,100,100,100,200,200,200,1000,200,3000,100,500,200,900,1000,2000,4000,100,3000,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,3000,2000,1000,300,400,500,600,700,800,900,1000,1000,1200,1300,1400,1500,1600,1700,1800,1900,100,10,15,900,70,1000,3000,1000,200,200,400,900,2000,2100,2200,2300,2400,2600,160,170,180,190,200,300,400,500,600,700,800,900}
                System.out.println(method.invoke(testClass, 2,10,new int[]{7,4,5,6}));
            } catch (Exception e){
                e.printStackTrace();
            }

            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }

    }

}
