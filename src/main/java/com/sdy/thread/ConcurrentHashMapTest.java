package com.sdy.thread;

import org.springframework.util.StopWatch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: sundy
 * @date: 2020/9/29 17:51
 * @description: 统计 key出现次数的场景
 * 使用最多 10 个并发，循环操作 1000 万次，每次操作累加随机的 Key
 * 如果 Key 不存在的话，首次设置值为 1。
 */
public class ConcurrentHashMapTest {
    private static int LOOP_COUNT = 10000000;
    private static int THREAD_COUNT = 10;
    private static int ITEM_COUNT = 10;

    private static Map<String, Long> normalUse() throws InterruptedException {
        ConcurrentHashMap<String, Long> freqs = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(i -> {
            // 获取一个随机的key
            String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
            synchronized (freqs) {
                if (freqs.containsKey(key)) {
                    // key 存在则 + 1
                    freqs.put(key, freqs.get(key) + 1);
                } else {
                    // key 不存在则初始化1
                    freqs.put(key, 1L);
                }
            }
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return freqs;
    }

    private static Map<String, Long> goodUse() throws InterruptedException {
        ConcurrentHashMap<String, LongAdder> freqs = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, LOOP_COUNT).parallel().forEach(i -> {
            String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
            // 利用computeIfAbsent()方法来实例化LongAdder，然后利用LongAdder来进行线程安全计数
            freqs.computeIfAbsent(key, k -> new LongAdder()).increment();
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        //因为我们的Value是LongAdder而不是Long，所以需要做一次转换才能返回
        return freqs.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey(),
                e -> e.getValue().longValue())
        );
    }


    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("normal use");
        normalUse();
        stopWatch.stop();
        stopWatch.start("good use");
        goodUse();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
