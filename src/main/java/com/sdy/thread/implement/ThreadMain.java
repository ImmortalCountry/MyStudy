package com.sdy.thread.implement;

import java.util.concurrent.*;

/**
 * @author: Sun Deyu
 * @date: 2020/5/28 11:45
 * @description:
 */
public class ThreadMain {
    public static void main(String[] args) {
//        testExtendThread();
//        testRunnable();
//        testCallBack();
        testThreadPool();
    }

    /**
     * 1. 继承 Thread 的实现方式
     */
    public static void testExtendThread() {
        for (int i = 0; i < 10; i++) {
            new ExtendsThread().start();
        }
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 2. 实现了 Runnable 接口的实现方式
     */
    public static void testRunnable() {
        ImplRunnable runnable = new ImplRunnable();
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * 3. 实现 CallBack 接口的实现方式
     */
    public static void testCallBack() {
        for (int i = 0; i < 10; i++) {
            Callable<Integer> callable = new ImplCallable();
            FutureTask<Integer> task = new FutureTask<>(callable);
            new Thread(task).start();
            try {
                System.out.println(Thread.currentThread().getName() + "----" + task.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 线程池
     * 和数据库池差不多
     * 避免了线程的创建和销毁造成的额外开销
     * java.util.concurrent
     * Executor 负责线程的使用和调度的根接口
     *      |-- ExecutorService 线程池的主要接口
     *          |-- ThreadPoolExecutor 线程池的实现类
     *          |-- ScheduledExecutorService 接口，负责线程的调度
     *              |-- ScheduledThreadPoolExecutor （extends ThreadPoolExecutor implements ScheduledExecutorService）
     * Executors 工具类
     * 提供了创建线程池的方法
     */
    public static void testThreadPool() {
        // 使用 Executors 工具类中的方法创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ImplThreadPool thread = new ImplThreadPool();
        // 为线程池中的线程分配任务，使用 submit 方法，传入的参数可以是 Runnable 的实现类
        // 也可以是 Callable的实现类
        for (int i = 0; i < 10; i++) {
            pool.submit(thread);
        }
        // 关闭线程池
        // shutdown : 以一种和平的方式关闭线程池，在关闭线程池之前，会等待线程池中的所有的任务都结束
        // 不接受新任务
        // shutDownNow ： 立即关闭线程池
        pool.shutdown();
    }

    static class ImplRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("实现 runnable 运行中..." + Thread.currentThread().getName());
        }
    }


    static class ExtendsThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承 Thread 运行中..." + Thread.currentThread().getName());
        }
    }

    static class ImplCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("实现 CallBack 接口..." + Thread.currentThread().getName());
            return 0;
        }
    }

    static class ImplThreadPool implements Runnable {

        @Override
        public void run() {
            System.out.println("实现 Runnable 接口的线程池..." + Thread.currentThread().getName());
        }
    }
}

/**
 *优点
 *
 * 重用线程池中的线程，避免因为线程的创建和销毁带来的性能开销。
 * 有效控制线程的最大并发数，避免因大量的线程之间互相抢占系统资源而导致的阻塞 。
 * 能够对线程进行简单的管理，并提供定时执行和执行循环间隔执行等功能
 *
 * public ThreadPoolExecutor(int corePoolSize,
 *                           int maximumPoolSize,
 *                           long keepAliveTime,
 *                           TimeUnit unit,
 *                           BlockingQueue<Runnable> workQueue,
 *                           ThreadFactory threadFactory,
 *                           RejectedExecutionHandler handler) {}
 *
 *变量
 *
 * corePoolSize: 核心线程数
 * maximumPoolSize: 最大线程数
 * workQueue:任务队列，提交的Runnable对象存储在这里。
 * keepAliveTime: 非核心线程存活时间
 * unit:keepAliveTime的时间单位。
 * threadFactory:为线程池提供新线程的工厂。
 * handler：异常处理策略。
 *
 *规则
 *
 * 如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
 * 如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
 * 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。
 * 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。
 *
 */
