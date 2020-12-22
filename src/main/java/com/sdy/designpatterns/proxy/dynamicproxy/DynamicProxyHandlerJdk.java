package com.sdy.designpatterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: sundy
 * @date: 2020/12/22 11:29
 * @description:
 */
public class DynamicProxyHandlerJdk implements InvocationHandler {
    private Object object;

    public DynamicProxyHandlerJdk(Object obj) {
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理：买房前");
        Object result = method.invoke(object, args);
        System.out.println("代理：买房后");
        return result;
    }

}
