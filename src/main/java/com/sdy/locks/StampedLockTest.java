package com.sdy.locks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author: sundy
 * @date: 2020/9/24 17:01
 * @description: 支持三种锁模式：
 * 1. 写锁
 * 2. 悲观读锁
 * 3. 乐观读：tryOptimisticRead
 * 1&2 和 ReadWriteLock 的写锁、读锁语义非常类似，
 * 允许多个线程同时获取悲观读锁，但只允许一个线程获取写锁，写锁和悲观读锁是互斥的
 * 不同的是：StampedLock 里的写锁和悲观读锁加锁成功之后，都会返回一个 stamp；然后解锁的时候，需要传入这个 stamp
 * StampLock 性能好的原因是：其支持乐观读；
 * ReadWriteLock 支持多个线程同时读，但是当多个线程同时读的时候，所有的写操作会被阻塞；
 * 而 StampedLock 提供的乐观读，是允许一个线程获取写锁的，也就是说不是所有的写操作都被阻塞。
 * 注意：乐观读！=乐观读锁。乐观读这个操作是无锁的，所以相比较 ReadWriteLock 的读锁，乐观读的性能更好一些。
 * 注意：StampedLock 不支持重入
 * 使用 StampedLock 一定不要调用中断操作，
 * 如果需要支持中断功能，一定使用可中断的悲观读锁 readLockInterruptibly() 和写锁 writeLockInterruptibly()
 * 支持锁升级和降级。
 */
public class StampedLockTest {
    private static final StampedLock sl = new StampedLock();

    public static void main(String[] args) {

    }

    public static void read() {
        long stamp = sl.readLock();
        try {
            // 业务
        } finally {
            sl.unlockRead(stamp);
        }
    }

    public static void write() {
        long stamp = sl.writeLock();
        try {
            // 业务
        } finally {
            sl.unlockWrite(stamp);
        }
    }


}
