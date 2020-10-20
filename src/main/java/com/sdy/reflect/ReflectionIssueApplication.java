package com.sdy.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: sundy
 * @date: 2020/10/15 11:19
 * @description: 反射调用方法遇到重载的坑
 */
public class ReflectionIssueApplication {
    Logger logger = LoggerFactory.getLogger(ReflectionIssueApplication.class);

    public void age(int age) {
        logger.info("int age={}", age);
    }

    public void age(Integer age) {
        logger.info("Integer age={}", age);
    }
}
