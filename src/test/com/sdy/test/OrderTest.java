package com.sdy.test;

import com.sun.org.apache.xpath.internal.operations.Or;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;
import org.springframework.util.StopWatch;

import static org.junit.Assert.*;

/**
 * @author: sundy
 * @date: 2020/10/14 14:59
 * @description:
 */
public class OrderTest {
    @Test
    public void test() {
        int elementCount = 1000000;
        int loopCount = 1000;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("listSearch");
        Object list = Order.listSearch(elementCount, loopCount);
        System.out.println(ObjectSizeCalculator.getObjectSize(list));
        stopWatch.stop();
        stopWatch.start("mapSearch");
        Object map = Order.mapSearch(elementCount, loopCount);
        stopWatch.stop();
        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        System.out.println(stopWatch.prettyPrint());
    }

}