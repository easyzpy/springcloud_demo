package com.zhangpingyang.eureka_server;

import org.junit.Test;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/10/18 16:52
 */
public class LambdaTest {
    @Test
    public void test1() {
        MathOperation mathOperation = (int a, int b) -> a + b;
        System.out.println(mathOperation.operation(1,2));
    }
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
