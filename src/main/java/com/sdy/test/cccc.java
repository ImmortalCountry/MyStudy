package com.sdy.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author: sundy
 * @date: 2021/1/22 15:22
 * @description:
 */
public class cccc {
    public static void main(String[] args) {
        List<String> pathList =  Lists.newArrayList("a", "a.b", "a.b.c", "a.b.d", "a.b.c.e");
        Map<Integer, List<String>> map = Maps.newHashMap();
        pathList.forEach(path -> {
            String temp = path.replace(".", "");
            if (map.containsKey(path)){
                
            }
            // map.put(temp.length(), path);
        });


    }
}
