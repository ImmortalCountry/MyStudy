package com.sdy.designpatterns.proxy.dynamicproxy

import com.sdy.designpatterns.proxy.BuyHouse
import com.sdy.designpatterns.proxy.BuyHouseImpl
import com.sdy.designpatterns.proxy.staticProxy.NoInterface
import net.sf.cglib.proxy.Enhancer
import net.sf.cglib.proxy.MethodInterceptor
import net.sf.cglib.proxy.MethodProxy
import spock.lang.Specification

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * @author: sundy*
 * @date: 2020/12/22 11:32g
 * @description:
 */
class DynamicProxyHandlerJdkTest extends Specification {

    def "dynamic proxy jdk"() {
        given:
        def buyHouse = new BuyHouseImpl();
        def proxy = (BuyHouse) Proxy.newProxyInstance(buyHouse.getClass().getClassLoader(), buyHouse.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                println("代理：买房前")
                Object value = method.invoke(buyHouse, args);
                println("代理：买房后")
                return value
            }
        })
        proxy.buyHouse()
    }

    def "dynamic proxy cglib"() {
        given:
        def noInterface = new NoInterface();
        def proxy = (NoInterface)Enhancer.create(noInterface.getClass(), new MethodInterceptor() {
            @Override
            Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                println("代理：买房前")
                Object obj = method.invoke(noInterface, args);
                println("代理：买房后")
                return obj
            }
        })
        proxy.print();
    }
}
