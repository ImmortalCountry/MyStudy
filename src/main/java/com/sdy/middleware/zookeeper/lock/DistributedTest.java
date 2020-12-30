package com.sdy.middleware.zookeeper.lock;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: sundy
 * @date: 2020/12/24 10:31
 * @description:
 */
public class DistributedTest {
    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 10;
    public static final int QUEUE_CAPACITY = 100;
    public static final Long KEEP_ALIVE_TIME = 1L;


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            // 创建 WorkerThread 对象，（WorkerThread 类实现了 Runnable 接口）
            // 执行 Runnable
            executor.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    TicketSeller ticketSeller = new TicketSeller();
                    ticketSeller.sellTicketWithLock();
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
} 
