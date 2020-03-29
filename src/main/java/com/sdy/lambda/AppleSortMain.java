package com.sdy.lambda;

import com.sdy.vo.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: sundy
 * @date: 2020/3/29 17:49
 * @description: 对苹果库存根据重量进行排序
 */
public class AppleSortMain {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(Apple.builder().weight(6).build(), Apple.builder().weight(10).build(), Apple.builder().weight(8).build());
        inventory.sort(new AppleComparator());

        // 一行 lambda 表达式解决问题
        inventory.sort(Comparator.comparing(Apple::getWeight));

        System.out.println(inventory);
    }
}
