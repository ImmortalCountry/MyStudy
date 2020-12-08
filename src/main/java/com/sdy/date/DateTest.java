package com.sdy.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author: sundy
 * @date: 2020/10/14 17:04
 * @description: 时区问题：
 */
public class DateTest {
    public static void main(String[] args) {
        // 初始化日期时间：2019 年 12 月 31 日 11 点 12 分 13 秒
//        test1();
        test2();
    }

    private static void test2() {
        // 一个时间表示
        String stringDate = "2020-01-02 22:00:00";
        //初始化三个时区
        ZoneId timeZoneSH = ZoneId.of("Asia/Shanghai");
        ZoneId timeZoneNY = ZoneId.of("America/New_York");
        ZoneId timeZoneJST = ZoneOffset.ofHours(9);
        //格式化器
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime date = ZonedDateTime.of(LocalDateTime.parse(stringDate, dateTimeFormatter), timeZoneJST);
        //使用DateTimeFormatter格式化时间，可以通过withZone方法直接设置格式化使用的时区
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z");
        System.out.println(timeZoneSH.getId() + outputFormat.withZone(timeZoneSH).format(date));
        System.out.println(timeZoneNY.getId() + outputFormat.withZone(timeZoneNY).format(date));
        System.out.println(timeZoneJST.getId() + outputFormat.withZone(timeZoneJST).format(date));
        
    }

    public static void test1() {
        // Date date = new Date(2019, 12, 31, 11, 12, 13);
        // 年是和1900的差值，月份从0-11
        Date date = new Date(2019 - 1900, 11, 31, 11, 12, 13);
        System.out.println(date);
        // 当有国际化需求的时候，需要使用 Calendar 类来初始化时间。
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 11, 31, 11, 12, 13);
        System.out.println(calendar.getTime());
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        instance.set(2019, Calendar.DECEMBER, 31, 11, 12, 13);
        System.out.println(instance.getTime());
    }

}
