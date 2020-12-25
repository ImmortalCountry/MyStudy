package com.sdy.designpatterns.observer.eventbus;

import com.sdy.designpatterns.observer.eventbus.EventBus;

import java.util.List;

/**
 * @author: sundy
 * @date: 2020/12/25 10:41
 * @description:
 */
public class ConcreteSubject {
    private EventBus eventBus;

    public ConcreteSubject() {
        this.eventBus = new EventBus();
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public void doBusiness(Object msg) throws InterruptedException {
        //done business
        Thread.sleep(1000);
        eventBus.post(msg);
    }
}
