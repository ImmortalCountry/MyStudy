package com.sdy.middleware.zookeeper.configcenter1;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * @author: sundy
 * @date: 2020/12/29 16:21
 * @description:
 */
@Slf4j
public class ZkGetConfigClient {

    private Config config;

    public Config getConfig() {
        ZkClient zk = new ZkClient("42.193.119.60:2181");
        config = zk.readData("/zkConfig");
        log.warn("加载到配置：{}", config.toString());
        System.out.println("加载到配置：" + config.toString());
        zk.subscribeDataChanges("/zkConfig", new IZkDataListener() {
            @Override
            public void handleDataChange(String arg0, Object arg1) throws Exception {
                config = (Config) arg1;
                log.warn("监听到配置文件被修改：{}", config.toString());
                System.out.println("监听到配置文件被修改：" + config.toString());
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                config = null;
                log.warn("监听到配置文件被删除");
                System.out.println("监听到配置文件被删除");
            }
        });
        return config;
    }

    public static void main(String[] args) {
        ZkGetConfigClient client = new ZkGetConfigClient();
        client.getConfig();
        System.out.println(client.config.toString());
        for (; ; ) {
            System.out.println(client.config.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
