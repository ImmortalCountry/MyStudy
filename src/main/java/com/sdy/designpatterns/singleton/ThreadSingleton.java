package com.sdy.designpatterns.singleton;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: sundy
 * @date: 2020/12/21 18:12
 * @description: 线程间单例
 */
public class ThreadSingleton {
    private static final ConcurrentHashMap<Long, ThreadSingleton> instances = new ConcurrentHashMap<>();

    private ThreadSingleton() {
    }
    public static ThreadSingleton getInstance() {
        long threadId = Thread.currentThread().getId();
        instances.putIfAbsent(threadId, new ThreadSingleton());
        return instances.get(threadId);
    }
}
