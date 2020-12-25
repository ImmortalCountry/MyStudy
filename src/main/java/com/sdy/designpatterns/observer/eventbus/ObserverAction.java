package com.sdy.designpatterns.observer.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author: sundy
 * @date: 2020/12/24 19:09
 * @description: 用来表示 @Subscribe
 * 注解的方法，其中，target 表示观察者类，method 表示方法。它主要用在 ObserverRegistry 观察者注册表中。
 */
public class ObserverAction {
    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }

    /**
     * @param event method方法的参数
     */
    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObserverAction that = (ObserverAction) o;
        return Objects.equals(target, that.target) && Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target, method);
    }
}
