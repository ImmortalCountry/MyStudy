package com.sdy.log.slf4h;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Sun Deyu
 * @date: 2020/6/2 16:29
 * @description:
 */
public class Slf4jTest {

    public static final Logger LOGGER = LoggerFactory.getLogger("com.sdy.log.slf4h.Slf4jTest");

    @Test
    public void test(){
        // 日志输出
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
        // 占位符
        String name = "jack";
        Integer age = 18;
        LOGGER.info("用户：{},{}", name, age);

    }
}
