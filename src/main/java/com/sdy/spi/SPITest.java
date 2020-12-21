package com.sdy.spi;

import java.util.ServiceLoader;

/**
 * @author: sundy
 * @date: 2020/12/20 18:37
 * @description:
 */
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        for (SPIService spi : load) {
            spi.print();
        }
    }
}
