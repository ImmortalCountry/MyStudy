package com.sdy.reflect;

/**
 * @author: sundy
 * @date: 2020/10/15 17:55
 * @description:
 */
public class Child1 extends Partner {
    public void setValue(String value) {
        System.out.println("Child1.setValue called");
        super.setValue(value);
    }
}
