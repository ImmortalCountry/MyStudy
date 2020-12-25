package com.sdy.designpatterns.observer.common;

import com.sdy.designpatterns.observer.common.Observer;

/**
 * @author: sundy
 * @date: 2020/12/24 17:52
 * @description:
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update() {
        System.out.println("ConcreteObserverTwo is notified.");
    }
}
