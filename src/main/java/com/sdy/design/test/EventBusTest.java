package com.sdy.design.test;

import com.sdy.design.observer.RegNotificationObserver;
import com.sdy.design.observer.RegPromotionObserver;
import com.sdy.design.observer.UserController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sun Deyu
 * @date: 2020/5/25 15:46
 * @description:
 */
public class EventBusTest {
    public static void main(String[] args) {
        UserController userController = new UserController();
        List<Object> observers = new ArrayList<>();
        observers.add(new RegPromotionObserver());
        observers.add(new RegNotificationObserver());
        userController.setRegObservers(observers);
        userController.testEventBus("v1");
    }
}
