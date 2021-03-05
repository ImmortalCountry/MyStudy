package com.sdy.thread.threadpool;

/**
 * @author: sundy
 * @date: 2021/1/29 10:54
 * @description: 自定义执行者
 */
public interface CustomizeExecutor {
    /**
     * 执行 Runnable的run方法
     * @param r
     */
    void execute(Runnable r);
}