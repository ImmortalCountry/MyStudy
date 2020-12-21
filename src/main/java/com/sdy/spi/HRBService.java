package com.sdy.spi;

/**
 * @author: sundy
 * @date: 2020/12/20 18:34
 * @description:
 */
public class HRBService implements SPIService{
    @Override
    public void print() {
        System.out.println("哈尔滨spi");
    }
}
