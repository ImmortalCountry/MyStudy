package com.sdy.test;

import org.apache.commons.collections4.Trie;

import java.net.URL;

/**
 * @author: sundy
 * @date: 2020/10/14 15:20
 * @description:
 */
public class B {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader classLoader = B.class.getClassLoader();
        URL url = classLoader.getResource("fileReader.txt");
        URL url2 = systemClassLoader.getResource( "fileReader.txt");
        Thread.currentThread().getContextClassLoader();
    }
}
