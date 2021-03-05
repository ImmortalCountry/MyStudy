package com.sdy.test;

import java.util.concurrent.TimeUnit;

/**
 * @author: sundy
 * @date: 2021/2/5 15:29
 * @description:
 */
public class dadad {
    public static void main(String[] args) throws InterruptedException {
        // int sleepTime = (int) (1 + Math.random() * (10 - 1));
        // System.out.println(("sdsad" + "这个").hashCode());
        for (int i = 0; i <100; i++) {
            int sleepTime = (int) (1 + Math.random() * (10 - 1));
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            long l = System.currentTimeMillis();
            String s = String.valueOf(l);
            // String substring = s.substring(s.length() / 2);
            System.out.println(s);
        }
    }
}
