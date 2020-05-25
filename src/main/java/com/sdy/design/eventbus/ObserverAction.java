package com.sdy.design.eventbus;

import com.google.common.base.Preconditions;
import lombok.EqualsAndHashCode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: sundy
 * @date: 2020/5/24 22:28
 * @description: 用来表示 @Subscribe 注解的方法
 */
@EqualsAndHashCode
public class ObserverAction {

    private Object target;
    private Method method;

    /**
     * @param target 观察者类
     * @param method 方法
     */
    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        // 可访问私有方法
        this.method.setAccessible(true);
    }

    public void execute(Object event) {
        try {
            // 执行方法
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
