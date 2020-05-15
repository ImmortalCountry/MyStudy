package com.sdy.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sundy
 * @date: 2020/5/14 16:19
 * @description:
 */
public class Main {
    public static void main(String[] args) {
//        test2();
        Test2 test2 = new Test2();
//        test2.test1();
//        test2.test2();
//        test2.test3();
//        test2.test4();
//        test2.test5();
//        test2.test6();
        test2.test7();


    }

    private static void test2() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        List<String[]> collect = list.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.get(0)));

        List<String> collect1 = list.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);
    }

    private static void test1() {
        StreamStudy ss = new StreamStudy();
        List<Dish> menu = ss.getMenu();
        List<String> collect = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
