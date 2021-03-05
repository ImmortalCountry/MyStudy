package com.sdy.thread.threadpool;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: sundy
 * @date: 2021/1/26 19:09
 * @description: 简化的线程池，仅用来说明原理
 */
public class SimpleThreadPool {
    /**
     * 利用阻塞队列实现生产者-消费者模式
     */
    BlockingQueue<Runnable> workQueue;
    /**
     * 保存内部工作线程
     */
    List<WorkerThread> threads = Lists.newArrayList();

    /**
     * 构造方法
     */
    SimpleThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        // 创建工作线程
        for (int idx = 0; idx < poolSize; idx++) {
            WorkerThread work = new WorkerThread();
            work.start();
            threads.add(work);
        }
    }
    @SneakyThrows
    void execute(Runnable command) {
        workQueue.put(command);
    }

    class WorkerThread extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            // 循环取任务并执行
            while (true) {
                Runnable task = workQueue.take();
                task.run();
            }
        }
    }

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);
        SimpleThreadPool pool = new SimpleThreadPool(10, workQueue);
        pool.execute(() -> System.out.println("running"));
    }
}
