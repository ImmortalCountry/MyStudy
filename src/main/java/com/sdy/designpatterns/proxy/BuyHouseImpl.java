package com.sdy.designpatterns.proxy;

/**
 * @author: sundy
 * @date: 2020/12/22 11:21
 * @description:
 */
public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("买房");
    }
}
