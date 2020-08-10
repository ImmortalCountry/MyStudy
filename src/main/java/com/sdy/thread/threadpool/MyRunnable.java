package com.sdy.thread.threadpool;

import java.util.Date;

/**
 * @author: SunDeYu
 * @date: 2020/8/10 16:43
 * @description:
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String command){
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start time : " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + "End time : " + new Date());
    }

    private void processCommand() {
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
