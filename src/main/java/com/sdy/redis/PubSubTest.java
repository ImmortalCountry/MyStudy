package com.sdy.redis;

import com.sdy.design.eventbus.Subscribe;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @author: sundy
 * @date: 2020/10/10 10:21
 * @description:
 */
public class PubSubTest extends JedisPubSub {
    private static PubSubTest listener = new PubSubTest();

    private static Jedis jedis = new Jedis("39.105.129.105");

    @Override
    public void onMessage(String channel, String message) {
        // 收到消息时候调用
        super.onMessage(channel, message);
        System.out.println("channel = " + channel + "message=" + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        // 订阅频道会调用
        System.out.println("channel = " + channel + "     " + subscribedChannels);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                jedis.subscribe(listener, "channel");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("开始发布");
                    publisher();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void publisher() throws InterruptedException {
        Thread.sleep(1000);
        for (int i = 0; i < 3; i++) {
            jedis.publish("channel", i+"");
            Thread.sleep(1000);
        }
    }

}
