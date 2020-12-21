package com.sdy.designpatterns.singleton;

/**
 * @author: sundy
 * @date: 2020/12/21 16:10
 * @description:
 */
public class StaticBlockSingleton {
    private static class SingletonHolder {
        private static final StaticBlockSingleton INSTANCE = new StaticBlockSingleton();
    }

    private StaticBlockSingleton() {
    }

    public static StaticBlockSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
