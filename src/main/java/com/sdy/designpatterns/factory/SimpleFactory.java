package com.sdy.designpatterns.factory;

import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: sundy
 * @date: 2020/12/21 19:26
 * @description: 类缓存或者if判断进行new
 */
public class SimpleFactory {
    private static final Map<String, String> mapCache = new HashMap<>();

    static {
        mapCache.put("a", "new 类a");
        mapCache.put("b", "new 类b");
        mapCache.put("c", "new 类c");
        mapCache.put("d", "new 类d");
        mapCache.put("e", "new 类e");
        mapCache.put("f", "new 类f");
        mapCache.put("g", "new 类g");
    }

    public static String createClass(String className) {
        if (Strings.isNullOrEmpty(className)) {
            return null;
        }
        return mapCache.get(className);
    }
}
