package com.sdy.designpatterns.observer.eventbus;

import java.util.concurrent.Executor;

/**
 * @author: sundy
 * @date: 2020/12/24 19:51
 * @description:
 */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
