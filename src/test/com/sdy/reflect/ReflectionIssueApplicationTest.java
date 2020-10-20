package com.sdy.reflect;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: sundy
 * @date: 2020/10/15 11:22
 * @description:
 */
public class ReflectionIssueApplicationTest {

    @Test
    public void test() throws Exception {
        ReflectionIssueApplication ref = new ReflectionIssueApplication();
//        ref.age(13);
//        ref.age(Integer.valueOf("13"));
        // 但使用反射时的误区是，认为反射调用方法还是根据入参确定方法重载
        ref.getClass().getDeclaredMethod("age", Integer.class).invoke(ref, 36);
        // 反射调用方法，是以反射获取方法时传入的方法名称和参数类型来确定调用方法的。

    }


}