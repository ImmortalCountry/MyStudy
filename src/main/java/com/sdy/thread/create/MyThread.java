package com.sdy.thread.create;

/**
 * @author: SunDeYu
 * @date: 2020/8/10 11:56
 * @description:
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "\t" + Thread.currentThread().getId());
    }
}
