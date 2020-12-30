package com.sdy.middleware.zookeeper.lock;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @author: sundy
 * @date: 2020/12/23 22:20
 * @description:
 */
public class TicketSeller {
    private void sell() {
        System.out.println("售票开始");
        // 线程随机休眠数毫秒，模拟现实中的费时操作
        int sleepMillis = (int) (Math.random() * 2000);
        try {
            //代表复杂逻辑执行了一段时间
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("售票结束");
    }
    public void sellTicketWithLock() throws KeeperException, InterruptedException, IOException {
        LockSample lock = new LockSample();
        lock.acquireLock();
        sell();
        lock.releaseLock();
    }
}
