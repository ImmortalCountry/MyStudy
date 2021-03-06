package com.sdy.thread.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: sundy
 * @date: 2020/9/30 11:38
 * @description:
 */
public class ItemTest {
    private static ConcurrentHashMap<String, Item> items = new ConcurrentHashMap<>();

    private static void init() {
        IntStream.range(0, 10).forEach(i -> items.put("item" + i, new Item("item" + i)));
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        // 并发进行100次下单操作，统计成功次数
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(i -> {
                    List<Item> cart = createCart();
                    return createOrder(cart);
                })
                .filter(result -> result)
                .count();
        System.out.printf("success:{} totalRemaining:{} took:{}ms items:{}",
                success,
                items.entrySet().stream().map(item -> item.getValue().remaining).reduce(0, Integer::sum),
                System.currentTimeMillis() - begin, items);
    }


    private static List<Item> createCart() {
        return IntStream.rangeClosed(1, 3)
                .mapToObj(i -> "item" + ThreadLocalRandom.current().nextInt(items.size()))
                .map(name -> items.get(name)).collect(Collectors.toList());
    }

    private static boolean createOrder(List<Item> order) {
        // 存放所有获得的锁
        List<ReentrantLock> locks = new ArrayList<>();
        for (Item item : order) {
            try {
                // 获得锁10s超时
                if (item.lock.tryLock(10, TimeUnit.SECONDS)) {
                    locks.add(item.lock);
                } else {
                    locks.forEach(ReentrantLock::unlock);
                    return false;
                }
            } catch (InterruptedException e) {
            }
        }
        // 获取全部锁之后执行扣减库存业务逻辑。
        try {
            order.forEach(item -> item.remaining--);
        } finally {
            locks.forEach(ReentrantLock::unlock);
        }
        return true;
    }
}
