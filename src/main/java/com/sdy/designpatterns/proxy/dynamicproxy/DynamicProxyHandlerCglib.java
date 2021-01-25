package com.sdy.designpatterns.proxy.dynamicproxy;

import com.sdy.designpatterns.proxy.BuyHouseImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: sundy
 * @date: 2020/12/22 14:15
 * @description:
 */
public class DynamicProxyHandlerCglib {
    public static void main(String[] args) {
        BuyHouseImpl aliSmsService = (BuyHouseImpl) CglibProxyFactory.getProxy(BuyHouseImpl.class);
        aliSmsService.buyHouse();

    }
}
