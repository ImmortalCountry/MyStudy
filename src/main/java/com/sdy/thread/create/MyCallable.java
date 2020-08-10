package com.sdy.thread.create;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author: SunDeYu
 * @date: 2020/8/10 14:34
 * @description: Callable 相对于 Runnable 可以有返回值。但是需要用 FutureTask 封装。
 */
public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t" + new Date() + " \tstarting...");
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += 1;
        }
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId() + "\t" + new Date() + " \tover...");
        return sum;
    }
}