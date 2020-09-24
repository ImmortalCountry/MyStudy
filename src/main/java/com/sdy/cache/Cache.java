package com.sdy.cache;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: sundy
 * @date: 2020/9/24 14:16
 * @description: 使用读写锁构建缓存类
 * ReadWriteLock 不支持锁升级：读锁没释放就获取写锁了：因为写的时候不允许读，
 * ReadWriteLock 支持锁降级：写锁没释放可以获取读锁
 * 使用缓存首先要解决的是缓存数据的初始化问题。
 * 方式：1. 按需加载；2. 一次性加载
 * 一次性加载适合数据量不大的形况，即查出全部数据后循环调用put。
 * 按需加载也叫懒加载，适合数据量大的情况。当缓存里没有数据的时候查db然后存入缓存。
 * 本类是按需
 *
 * 作者回复: 获取写锁的前提是读锁和写锁均未被占用
 * 获取读锁的前提是没有其他线程占用写锁
 * 申请写锁时不中断其他线程申请读锁
 * 公平锁如果过有写申请，能禁止读锁
 */
public class Cache<K, V> {
    final HashMap<K, V> cache = new HashMap<>();
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K key) {
        r.lock();
        try {
            return cache.get(key);
        } finally {
            r.unlock();
        }
    }

    V put(K key, V value) {
        w.lock();
        try {
            return cache.put(key, value);
        } finally {
            w.unlock();
        }
    }
}
