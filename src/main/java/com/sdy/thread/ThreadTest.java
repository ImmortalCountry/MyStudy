package com.sdy.thread;

import com.sdy.thread.create.MyCallable;
import com.sdy.thread.create.MyRunnable;
import com.sdy.thread.create.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: SunDeYu
 * @date: 2020/8/10 11:58
 * @description:
 */
public class ThreadTest {
    public static void main(String[] args) {
        FutureTaskTest();
    }

    private static void FutureTaskTest() {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        Integer sum = null;
        try {
            // get 方法会阻塞调用的线程。[计算]
            sum = futureTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "=" + sum);
    }

    private static void myRunnableTest() {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
    }

    private static void myThreadTest() {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}
