package com.sdy.test;

import com.google.common.collect.Lists;
import com.sdy.callBack.BookCallBack;
import com.sdy.callBack.ICallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: sundy
 * @date: 2020/4/28 22:30
 * @description:
 */
public class Main {

    @Test
    public void main(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,"1");
        Object o = map.get(1);

        System.out.println(o);
        System.out.println(o.equals("1"));
        ThreadLocal<Object> local = new ThreadLocal<>();
        Thread thread = new Thread();

//        TestBookCallBack testBookCallBack = new TestBookCallBack();
//        testBookCallBack.test(new ICallBack() {
//            @Override
//            public void execute() {
//                System.out.println("Anonymous Inner Class");
//            }
//        });

//        BookCallBack bookCallBack = new BookCallBack();
//        testBookCallBack.test(bookCallBack);
//        List<String> tentands = Lists.newArrayList("1","2","3","4","5","6");
//        List<String> re = Lists.newArrayList("2","4","6");
//        tentands.parallelStream().forEach(t->{
//            if (re.contains(t)){
//                return;
//            }
//            System.out.println(t);
//        });
//        if(T1.isTrue()){
//            System.out.println("ok");
//        }

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        List<String> collect = list.stream().filter(x -> x.equals("1")).collect(Collectors.toList());
//        collect.set(0, "6");
//        System.out.println(collect);
//        System.out.println(list);


    }

}
