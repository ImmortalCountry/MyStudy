package com.sdy.designpatterns.observer.common;

import com.sdy.designpatterns.observer.common.Observer;
import com.sdy.designpatterns.observer.common.Subject;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: sundy
 * @date: 2020/12/24 17:38
 * @description:
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
