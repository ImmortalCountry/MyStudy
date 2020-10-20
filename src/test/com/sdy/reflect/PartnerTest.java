package com.sdy.reflect;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: sundy
 * @date: 2020/10/15 17:57
 * @description:
 */
public class PartnerTest {
    @Test
    public void test() {
        Child1 child = new Child1();
        Arrays.stream(child.getClass().getMethods())
                .filter(method -> method.getName().equals("setValue"))
                .forEach(method -> {
                    try {
                        method.invoke(child, "test");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        System.out.println(child.toString());
    }

}