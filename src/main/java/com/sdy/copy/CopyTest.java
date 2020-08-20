package com.sdy.copy;

import org.junit.Test;

/**
 * @author: SunDeYu
 * @date: 2020/8/20 10:38
 * @description:
 */
public class CopyTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        CopyObject obj = new CopyObject();
        Object clone = obj.clone();
        System.out.println(obj == clone);
    }
}
