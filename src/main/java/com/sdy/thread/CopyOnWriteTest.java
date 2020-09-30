package com.sdy.thread;

import org.springframework.util.StopWatch;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: sundy
 * @date: 2020/9/29 19:58
 * @description:
 */
public class CopyOnWriteTest {
    public static void main(String[] args) {
//        System.out.println(testWrite());
        System.out.println(testRead());
    }

    private static Map testWrite() {
        List<Integer> copyOnWrite = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        StopWatch stopWatch = new StopWatch();
        int lopCount = 100000;
        stopWatch.start("write:copyOnWrite");
        IntStream.rangeClosed(1, lopCount).parallel().forEach(__ -> copyOnWrite.add(ThreadLocalRandom.current().nextInt(lopCount)));
        stopWatch.stop();
        stopWatch.start("write:synchronized");
        IntStream.rangeClosed(1, lopCount).parallel().forEach(__ -> synchronizedList.add(ThreadLocalRandom.current().nextInt(lopCount)));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        Map result = new HashMap();
        result.put("copyOnWrite", copyOnWrite.size());
        result.put("synchronizedList", synchronizedList.size());
        return result;
    }

    private static void addAll(List<Integer> list) {
        list.addAll(IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList()));
    }

    private static Map testRead() {
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        // 填充数据
        addAll(copyOnWriteList);
        addAll(synchronizedList);
        StopWatch stopWatch = new StopWatch();
        int loopCount = 1000000;
        int count = copyOnWriteList.size();
        stopWatch.start("Read；copyOnWriteList");
        // 循环1000000次并发从copyOnWrite中随机查询元素
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__ -> copyOnWriteList.get(ThreadLocalRandom.current().nextInt(count)));
        stopWatch.stop();
        stopWatch.start("Read：synchronizedList");
        // 循环1000000次并发读
        IntStream.rangeClosed(1, loopCount).parallel().forEach(__ -> synchronizedList.get(ThreadLocalRandom.current().nextInt(count)));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        Map result = new HashMap();
        result.put("copyOnWriteList", copyOnWriteList.size());
        result.put("synchronizedList", synchronizedList.size());
        return result;
    }
}
