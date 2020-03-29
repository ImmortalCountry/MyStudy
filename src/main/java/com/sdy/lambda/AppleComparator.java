package com.sdy.lambda;

import com.sdy.vo.Apple;

import java.util.Comparator;

/**
 * @author: sundy
 * @date: 2020/3/29 17:31
 * @description: 根据重量实现苹果的排序比较器
 */
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
