package com.sdy.thread;

/**
 * CAS
 * @author 18846
 */
public class CAS {
    public static volatile int race = 0;
    private static final int THREADS_COUNT = 20;

    public static void increase(){
        race++;
    }
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                     increase();
                    }
                }
            });
            threads[i].start();
        }

        // activeCount 此方法返回活动线程的当前线程的线程组中的数量。
        while (Thread.activeCount() > 1){
            // 使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。cpu会从众多的可执行态里选择，
            // 也就是说，当前也就是刚刚的那个线程还是有可能会被再次执行到的，
            // 并不是说一定会执行其他线程而该线程在下一次中不会执行到了。
            Thread.yield();
        }

        System.out.println(race);
    }
}
