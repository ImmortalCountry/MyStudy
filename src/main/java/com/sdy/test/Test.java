package com.sdy.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sun Deyu
 * @date: 2020/6/8 19:28
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        B b = new B("b");
        A a = new A(b);
        System.out.println(a);
        b.setName("c");
        System.out.println(a);


//        String str = "";k
//        StringBuffer sb = new StringBuffer();
//        StringBuilder sbr = new StringBuilder();
//        System.out.println(2.0/0);
//
//        List<T> list = new ArrayList<>(20);
//
//        for (int i = 0; i < 20; i++){
//            if (i == 10){
//                list.add(new T(null));
//                continue;
//            }
//            list.add(new T(i+""));
//        }
//
//        list.forEach(t->{
//            System.out.println(t.getName().toString());
//        });
//        Long.valueOf(null);

    }
    @Data
    @AllArgsConstructor
    public static class A {
        B b;
    }

    @Data
    @AllArgsConstructor
    public static class B {
        String name;
    }
}
