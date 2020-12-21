package com.sdy.designpatterns.singleton;

/**
 * @author: sundy
 * @date: 2020/12/21 15:59
 * @description: 饿汉单例
 */
public class EagerSingleton {
    private static volatile EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
