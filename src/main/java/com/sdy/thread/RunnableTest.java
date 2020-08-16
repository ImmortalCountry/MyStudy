package com.sdy.thread;

import com.google.common.util.concurrent.AtomicDouble;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: SunDeYu
 * @date: 2020/8/16 18:39
 * @description:
 */
public class RunnableTest implements Runnable{
    private AtomicInteger successCount;

    public RunnableTest(){
        this.successCount = new AtomicInteger(0);
    }
    @Override
    public void run() {
        successCount.incrementAndGet();
    }
}
