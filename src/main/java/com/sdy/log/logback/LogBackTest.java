package com.sdy.log.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Sun Deyu
 * @date: 2020/6/2 17:35
 * @description:
 * 依次加载配置
 * - logback.groovy
 * - logback-test.xml
 * - logback.xml
 * 如果都没有则默认配置
 * Logger
 * Appender：日志输出目的地
 * Layout：日志格式， 在 logback 里，把 layout 对象封装在 encoder 中。
 */
public class LogBackTest {
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
