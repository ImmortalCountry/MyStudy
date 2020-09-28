package com.sdy.calculation;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: sundy
 * @date: 2020/9/27 19:26
 * @description:
 */
public class MySet {
    public static void main(String[] args) {
        Set<String> s1 = Sets.newHashSet("1", "2", "3", "4");
        Set<String> s2 = Sets.newHashSet("1", "2", "9", "5");
        System.out.println(complement(s1, s2));
    }

    public static Set<String> intersection(Set<String> s1, Set<String> s2) {
        Set<String> result = new HashSet<>(s1);
        result.retainAll(s2);
        return result;
    }

    public static Set<String> union(Set<String> s1, Set<String> s2) {
        Set<String> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }


    public static Set<String> difference(Set<String> superset, Set<String> subset) {
        Set<String> result = new HashSet<>(superset);
        result.addAll(subset);
        return result;
    }

    public static Set<String> complement(Set<String> s1, Set<String> s2) {
        return difference(union(s1, s2), intersection(s1, s2));
    }
}
