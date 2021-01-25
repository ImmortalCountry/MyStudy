package com.sdy.thread;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: sundy
 * @date: 2021/1/25 18:05
 * @description:
 */
public class test {
    public static void main(String[] args) {
        List<String> str = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            str.add(i + "");
        }
        str.parallelStream().forEach(x->{
            if (x.equals("5")){
                int a = 5/0;
            }
            System.out.println(x);
        });
        System.out.println("over");
    }
}
