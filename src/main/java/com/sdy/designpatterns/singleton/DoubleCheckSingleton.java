package com.sdy.designpatterns.singleton;

/**
 * @author: sundy
 * @date: 2020/12/21 16:02
 * @description: 双重检查的单例
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized(DoubleCheckSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
