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
        Map<String, List<String>> stringListMap = specAndSpecValue("颜色:红色; 内存:256G; 尺寸: 5.0;");
        System.out.println(stringListMap);
    }
    public static Map<String, List<String>> specAndSpecValue(String productSpec) {
        productSpec.replace("；", ";");
        productSpec.replace("：", ":");
        /**
         * 颜色:红色; 内存:256G; 尺寸: 5.0;
         */
        int firstPoint = 0;
        int secondPoint = 0;
        String newStr = productSpec;

        List<String> specList = Lists.newArrayList();
        List<String> specValueList = Lists.newArrayList();


        while (newStr.indexOf(":") != -1) {
            firstPoint = newStr.indexOf(":");
            String spec = newStr.substring(0, firstPoint);
            specList.add(spec);
            newStr = newStr.substring(firstPoint + 1);
            secondPoint = newStr.indexOf(";");
            specValueList.add(newStr.substring(0, secondPoint));
            newStr = newStr.substring(secondPoint + 1);
        }
        Map<String, List<String>> maps = Maps.newHashMap();
        maps.put("spec", specList);
        maps.put("specValue", specValueList);
        return maps;
    }

}
