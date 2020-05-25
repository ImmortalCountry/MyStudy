package com.sdy.design.eventbus;

import java.util.concurrent.Executor;

/**
 * @author: Sun Deyu
 * @date: 2020/5/25 15:45
 * @description:
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
