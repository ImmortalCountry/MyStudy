package com.sdy.designpatterns.singleton;

/**
 * @author: sundy
 * @date: 2020/12/21 15:55
 * @description: 懒汉单例
 */
public class LazySingleton {
    private static volatile LazySingleton instance;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
