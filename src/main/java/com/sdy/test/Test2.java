package com.sdy.test;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: SunDeYu
 * @date: 2020/8/20 16:50
 * @description:
 */
public class Test2 {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>(2);
        map.put("a", Lists.newArrayList("1","2","3"));
        map.put("b", Lists.newArrayList("4","5","6"));
        for (Map.Entry<String, List<String>> old : map.entrySet()){
            old.getValue().remove("1");
            System.out.println(old);
        }

        System.out.println(map);
    }

}
