package com.sdy.calculation;

/**
 * @author: SunDeYu
 * @date: 2020/8/5 16:48
 * @description: 精度问题测试
 */
public class AccuracyTest {
    public static void main(String[] args) {
        System.out.println(0.01+0.05);
        System.out.println(1-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
        System.out.println(Arith.add(0.01, 0.05));
        System.out.println(Arith.sub(1, 0.42));
        System.out.println(Arith.mul(4.015, 100));
        System.out.println(Arith.div(123.3, 100));
    }
}
