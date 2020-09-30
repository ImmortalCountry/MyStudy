package com.sdy.locks;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author: sundy
 * @date: 2020/9/28 17:23
 * @description:
 */
public class MyLock extends AbstractQueuedSynchronizer {
    public static void main(String[] args) {
        CyclicBarrier c = new CyclicBarrier(1);
    }
}
