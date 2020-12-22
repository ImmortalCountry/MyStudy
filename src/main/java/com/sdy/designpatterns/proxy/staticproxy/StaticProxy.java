package com.sdy.designpatterns.proxy.staticproxy;

import com.sdy.designpatterns.proxy.BuyHouse;

/**
 * @author: sundy
 * @date: 2020/12/22 11:23
 * @description:
 */
public class StaticProxy implements BuyHouse {
    private BuyHouse buyHouse;

    public StaticProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("代理：买房前");
        buyHouse.buyHouse();
        System.out.println("代理，买房后");
    }
}
