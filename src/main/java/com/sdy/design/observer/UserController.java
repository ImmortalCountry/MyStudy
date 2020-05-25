package com.sdy.design.observer;

import com.sdy.design.eventbus.EventBus;

import java.util.List;

/**
 * @author: Sun Deyu
 * @date: 2020/5/25 16:02
 * @description:
 */
public class UserController {
    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController() {
        eventBus = new EventBus();
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public void testEventBus(String str) {
        // 其他逻辑
        eventBus.post(str);
    }
}
