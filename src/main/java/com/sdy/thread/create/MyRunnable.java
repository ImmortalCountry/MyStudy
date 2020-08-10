package com.sdy.thread.create;

/**
 * @author: SunDeYu
 * @date: 2020/8/10 12:01
 * @description:
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
    }
}
