package com.sdy.design.observer;

import com.sdy.design.eventbus.Subscribe;

/**
 * @author: Sun Deyu
 * @date: 2020/5/25 16:12
 * @description:
 */
public class RegNotificationObserver {

    @Subscribe
    public void handleRegSuccess(String str) {
        System.out.println("版本是:" + str);
        System.out.println("执行了通知");
    }
}
