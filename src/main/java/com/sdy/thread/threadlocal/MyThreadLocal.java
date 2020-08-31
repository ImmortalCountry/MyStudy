package com.sdy.thread.threadlocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: SunDeYu
 * @date: 2020/8/24 17:39
 * @description:
 */
public class MyThreadLocal {
    public static void main(String[]  args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Random random = new Random();
        IntStream.range(0, 5).forEach(a -> new Thread(() -> {
            threadLocal.set(a + " " + random.nextInt(10));
            System.out.println("线程和 local 值分别是 " + threadLocal.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start());
    }
}
// Sonar