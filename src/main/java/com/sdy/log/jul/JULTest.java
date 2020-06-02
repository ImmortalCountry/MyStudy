package com.sdy.log.jul;

import org.junit.Test;

import java.io.Console;
import java.io.IOException;
import java.util.logging.*;

/**
 * @author: Sun Deyu
 * @date: 2020/6/2 10:29
 * @description: 不需要导入第三方依赖， java 自带日志系统
 * JUL 默认日志输出级别是 info
 */
public class JULTest {
    Logger logger = Logger.getLogger("com.sdy.log.jul.JULTest");
    @Test
    public void test() throws Exception {
        setLoggerLevel();
        // 获取日志记录器
        logger.info("消息内容");
        // 通用方法进行日志记录
        logger.log(Level.INFO, "info message");
        logger.warning("这是警告信息");
        // 通过占位符输出变量的值
        String name = "kaka";
        Integer age = 13;
        logger.log(Level.INFO,"用户信息：{0},{1}", new Object[]{name, age});
    }
    /**
     * 自定义配置
     * @throws IOException
     */
    private void setLoggerLevel() throws IOException {
        // 关闭系统默认配置
        logger.setUseParentHandlers(false);
        // 自定义配置日志级别

        // 创建 ConsoleHandle
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联

        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        // 配置日志具体级别
        logger.setLevel(Level.WARNING);
        consoleHandler.setLevel(Level.WARNING);
    /**************************************************************************/
        // 创建 FileHandle 文件输出
        FileHandler fileHandler = new FileHandler("jul.log");
        // 进行关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
    }
}
