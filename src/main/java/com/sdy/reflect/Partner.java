package com.sdy.reflect;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: sundy
 * @date: 2020/10/15 17:53
 * @description:
 */
public class Partner<T> {
    /**
     * 用于记录value更新的次数
     */
    AtomicInteger updateCount = new AtomicInteger();
    private T value;

    @Override
    public String toString() {
        return String.format("value: %s updateCount: %d", value, updateCount.get());
    }

    public void setValue(T value) {
        this.value = value;
        updateCount.incrementAndGet();
    }
}
