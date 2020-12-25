package com.sdy.designpatterns.observer.common;


/**
 * @author: sundy
 * @date: 2020/12/24 17:37
 * @description:
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
