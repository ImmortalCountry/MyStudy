package com.sdy.task;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: sundy
 * @date: 2020/5/15 18:53
 * @description:
 */
public class TimeTask {
    /**
     * Thread
     * 创建 Thread 在循环中运行
     * 通过 sleep 方法达到定时任务的效果。
     */
    public static void task1() {
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // todo run task
                    System.out.println("run task");
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void task2() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("run task");
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long period = 1 * 1000;
        timer.scheduleAtFixedRate(timerTask, delay, period);
//        timer.schedule(timerTask, delay);
    }

    public static void task3() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run task");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 3, 1, TimeUnit.SECONDS);
//        service.schedule(runnable, 2, TimeUnit.SECONDS);
    }
}
