package com.sdy.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.logging.Logger;

/**
 * @author: sundy
 * @date: 2020/10/12 10:56
 * @description:
 */
public class LogTest {

        private static Log logCommon = LogFactory.getLog(LogTest.class);
    // 实例中使用
    // protected final log log = logfactory.getlog(getclass());

    public static void main(String[] args) {

//        javaLogTest();

//        commonLog();
        logbackTest();
    }

    private static void logbackTest() {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LogTest.class);
        logger.info("logback info test");
    }

    private static void commonLog() {
        logCommon.info("apache log info test");
    }

    public static void javaLogTest(){
        Logger logger = Logger.getLogger("testLog");
        logger.info("info log test");
        logger.warning("warning log test");
        // 日志级别是info，所以fine不打印
        // 配置在jre安装目录的lib下面。
//        logger.fine("fine log test");
    }
}
