package com.sdy.designpatterns.observer.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: sundy
 * @date: 2020/12/24 19:07
 * @description: 标明观察者中的哪个函数可以接收消息
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
}
