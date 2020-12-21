package com.sdy.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sun Deyu
 * @date: 2020/6/8 19:28
 * @description:
 */
@Slf4j
public class Test {


    private  static int x = 0, y = 0;
    private  static int a = 0, b = 0;

    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
//        B b = new B("b");
//        A a = new A(b);
//        System.out.println(a);
//        b.setName("c");
//        System.out.println(a);


//        for (String arg : args) {
//            System.out.println("arg:" + arg);
//        }
//
//        System.out.println("-Xmx" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        // try{
        //     recursion();
        // }catch (Throwable e){
        //     System.out.println("deep of calling = " + count);
        //     e.printStackTrace();
        // }
//        String str = "";k
//        StringBuffer sb = new StringBuffer();
//        StringBuilder sbr = new StringBuilder();
//        System.out.println(2.0/0);
//
//        List<T> list = new ArrayList<>(20);
//
//        for (int i = 0; i < 20; i++){
//            if (i == 10){
//                list.add(new T(null));
//                continue;
//            }
//            list.add(new T(i+""));
//        }
//
//        list.forEach(t->{
//            System.out.println(t.getName().toString());
//        });
//        Long.valueOf(null);
//         String str2 = new StringBuilder("cla").append("ss").toString();
//         System.out.println(str2 == str2.intern());
//
//
//         String str3 = new StringBuilder("ja").append("va").toString();
//         System.out.println(str3 == str3.intern());

            int i = 0;
            for (;;){
                i++;
                x = 0; y = 0;
                a = 0; b = 0;
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
//                    shortWait(10000);
                        a = 1;
                        x = b;
                    }
                });

                Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        b = 1;
                        y = a;
                    }
                });

                t1.start();
                t2.start();
                t1.join();
                t2.join();

                String result = "第" + i + "次 (" + x + "," + y + "）";
                if(x == 0 && y == 0) {
                    System.out.println(result);
                    break;
                } else {
                    log.info(result);
                }
            }

        }


        /**
         * 等待一段时间，时间单位纳秒
         * @param interval
         */
        public static void shortWait(long interval) {
            long start = System.nanoTime();
            long end;
            do {
                end = System.nanoTime();
            } while (start + interval >= end);
        }

    private static void recursion() {
        count++;
        recursion();
    }

    @Data
    @AllArgsConstructor
    public static class A {
        B b;
    }

    @Data
    @AllArgsConstructor
    public static class B {
        String name;
    }
}
