package com.sdy.redis;

import redis.clients.jedis.Jedis;

/**
 * @author: sundy
 * @date: 2020/9/25 10:39
 * @description:
 */
public class MyRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("39.105.129.105");
        System.out.println("connect success");
        jedis.set("key4j", "value4j");
        System.out.println("redis 存储的字符串为：" + jedis.get("key4j"));
    }
}
