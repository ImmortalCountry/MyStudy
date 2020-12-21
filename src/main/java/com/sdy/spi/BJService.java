package com.sdy.spi;

/**
 * @author: sundy
 * @date: 2020/12/20 18:34
 * @description:
 */
public class BJService implements SPIService{
    @Override
    public void print() {
        System.out.println("北京spi");
    }
}
