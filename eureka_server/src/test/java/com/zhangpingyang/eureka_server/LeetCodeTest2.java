package com.zhangpingyang.eureka_server;

import org.junit.Test;

import java.awt.*;
import java.util.regex.Pattern;

/**
 * @Author: Zhang Pingyang
 * @Date: 2019/10/18 10:17
 */
public class LeetCodeTest2 {

    @Test
    public void test(){
        String regex = "/^[a]*$/";
        Pattern compile = Pattern.compile(regex);
        System.out.println(compile.matcher("ab").matches());
        System.out.println(compile.matcher("abc").matches());
        System.out.println(compile.matcher("bc").matches());


//        int maxValue = Integer.MAX_VALUE;
////        System.out.println(1534236469);
////        System.out.println(9646324351);
//        int a = 9646324351;
//        int reverse = reverse(1534236469);
//        System.out.println(reverse);
    }

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean changed = false;
        if (x < 0) {
            x = -x;
            changed = true;
        }
        StringBuilder sb = new StringBuilder(x + "");
        String s = sb.reverse().toString();
        boolean flag = true;
        StringBuilder result = new StringBuilder();
        for(char c: s.toCharArray()){
            if(flag && '0' == c){
                continue;
            }else{
                flag = false;
            }
            result.append(c);
        }
        if (changed) result.insert(0, "-");
        return Integer.parseInt(result.toString());
    }

}
