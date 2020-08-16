package com.sdy.stream;

import com.google.common.base.Stopwatch;
import lombok.SneakyThrows;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: SunDeYu
 * @date: 2020/8/16 17:13
 * @description:
 */
public class TestStream {
    static private AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add("task" + i);
        }
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true){
                    Thread.sleep(100);
                    System.out.println((count.get() / 10000000.0)*100);
                    if (count.get() == 10000000){
                        break;
                    }
                }
            }
        }).start();
        System.out.println("begin " + new Date());
        list.parallelStream().forEach(t->{

                count.incrementAndGet();


        });
        System.out.println("end " + new Date());
        System.out.println("count = " + count.get());

//        list.parallelStream().forEach(p -> {
//                    System.out.println(new Date() + "begin  " + p);
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(new Date() + "end " + p);
//                }
//        );


//        StopWatch stopwatch = new StopWatch("test");
//        stopwatch.start("one");
//        Thread.sleep(1000);
//        stopwatch.stop();
//        stopwatch.start("two");
//        Thread.sleep(5000);
//        stopwatch.stop();
//        stopwatch.start("three");
//        Thread.sleep(4000);
//        stopwatch.stop();
//        System.out.println(stopwatch.prettyPrint());
//
//        System.out.println(stopwatch.prettyPrint());


    }
}
