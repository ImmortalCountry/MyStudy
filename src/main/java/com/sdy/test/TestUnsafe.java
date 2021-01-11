package com.sdy.test;

import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;

public class TestUnsafe {

    private volatile int total;
    static Unsafe unsafe = UnsafeInstance.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (TestUnsafe.class.getDeclaredField("total"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        long start = System.currentTimeMillis();
        TestUnsafe test = new TestUnsafe();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {
                    getAndAddInt(test, valueOffset, 1);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - start);

    }

    public final static int getAndAddInt(Object obj, long offset, int update) {
        int expect;
        do {
            expect = unsafe.getIntVolatile(obj, offset);
        } while (!unsafe.compareAndSwapInt(obj, offset, expect, expect + update));

        return expect;
    }

}