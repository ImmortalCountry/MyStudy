package com.sdy.enums;

/**
 * @author: SunDeYu
 * @date: 2020/8/17 10:47
 * @description: 颜色枚举类。枚举学习;
 * RED、BLUE、GREEN、YELLOW 都是实例。即 Color 一共有四个实例对象。
 * 枚举类中的实例就是类中的枚举项，所以不用 new 来创建枚举类对象。通过类名.枚举项
 * 构造器：枚举类也可以有构造器，构造器默认都是private修饰，而且只能是private。因为枚举类的实例不能让外界来创建！
 */
public enum Color {
    /**
     * 红、蓝、绿、黄
     */
    RED("红"), BLUE("蓝"), GREEN("绿"), YELLOW("黄");

    Color(String name) {
    }
}
