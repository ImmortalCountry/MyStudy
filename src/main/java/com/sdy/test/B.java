package com.sdy.test;

import com.google.common.collect.Lists;
import com.sdy.netty.ChatClient;
import org.apache.commons.collections4.Trie;
import org.springframework.util.StopWatch;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: sundy
 * @date: 2020/10/14 15:20
 * @description:
 */
public class B {
    // public static void main(String[] args) {
    //     // ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
    //     // ClassLoader classLoader = B.class.getClassLoader();
    //     // URL url = classLoader.getResource("fileReader.txt");
    //     // URL url2 = systemClassLoader.getResource( "fileReader.txt");
    //     // Thread.currentThread().getContextClassLoader();
    //
    // }
    public static StopWatch stopWatch = new StopWatch();
    public static AtomicInteger total = new AtomicInteger(0);
    public static int t = 0;
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Object object = new Object();
    public static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws Exception {
        //     stopWatch.start();
        //     for (int i = 0; i < 10; i++) {
        //         new Thread(() -> {
        //             for (int j = 0; j < 10000000; j++) {
        //                 reentrantLock.lock();
        //                 t++;
        //                 reentrantLock.unlock();
        //                     // total.incrementAndGet();
        //             }
        //             countDownLatch.countDown();
        //         }).start();
        //     }
        //     countDownLatch.await();
        //     System.out.println(t);
        //     stopWatch.stop();
        //     System.out.println(stopWatch.prettyPrint());
        // }
        // Map<String, String> map = new HashMap<>();
        // System.out.println(map.get("a"));
        // for (int i = 0; i < 10; i++) {
        //     System.out.println(i);
        // }
        // System.out.println();
        // for (int i = 0; i < 10; System.out.println("到我了")) {
        //     System.out.println(i);
        //     i++;
        // }
        // List<String> list = Lists.newArrayList("1", "2", "3");
        // for (String s : list) {
        //     if (s.equals("2")) {
        //         list.remove(s);
        //     }
        // }
        // System.out.println(list);
        // list.forEach(s -> {
        //     if (s.equals("1")) {
        //         list.remove(s);
        //     }
        // });
        for (int i = 0; i < 1000; i++) {

            new ChatClient().main();
        }
    }
}
