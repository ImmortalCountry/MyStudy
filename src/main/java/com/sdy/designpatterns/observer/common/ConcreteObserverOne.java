package com.sdy.designpatterns.observer.common;

import com.sdy.designpatterns.observer.common.Observer;

/**
 * @author: sundy
 * @date: 2020/12/24 17:51
 * @description:
 */
public class ConcreteObserverOne implements Observer {
    @Override
    public void update() {
        System.out.println("ConcreteObserverOne is notified.");
    }
}