package com.sdy.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: sundy
 * @date: 2020/11/9 11:22
 * @description:
 */
public class tttt {
    public static void main(String[] args) {
        Map<String, List<String>> map = Maps.newHashMap();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\product_category3.csv"));
            reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                if (map.containsKey(item[1])) {
                    List<String> l = map.get(item[1]);
                    l.add(item[2]);
                    map.put(item[1], l);
                } else {
                    map.put(item[1], Lists.newArrayList(item[2]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Set<String> set = map.keySet();
        System.out.println("steCount" + set.size());
        int count = 0;
        for (String x : set) {
            System.out.println(map.get(x).size());
            count += map.get(x).size();
        }
        System.out.println(count);
    }

    public static List<String> groupList(List list){

        ArrayList<String> result = Lists.newArrayList();
        //listSize为集合长度
        int listSize=list.size();
        //每次取1000条
        int index=1000;
        //用map存起来新的分组后数据
        for(int i = 0;i<list.size();i+=1000){
            //作用为Index最后没有1000条数据，则剩余的条数newList中就装几条
            if(i+1000>listSize){
                index=listSize-i;
            }
            //使用subList方法，keyToken用来记录循环了多少次或者每个map数据的键值
            result.addAll(list.subList(i,i+index));
            System.out.println(result.size());
        }
        return result;
    }
}

