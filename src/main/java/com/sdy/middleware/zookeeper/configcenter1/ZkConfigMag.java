package com.sdy.middleware.zookeeper.configcenter1;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author: sundy
 * @date: 2020/12/29 16:14
 * @description:
 */
public class ZkConfigMag {

    private Config config;

    public void setConfig(Config config) {
        this.config = config;
    }

    public Config downLoadConfigFromDB() {
        config = new Config("nm", "pw");
        return config;
    }
    public void upLoadConfigToDB(String nm, String pw){
        if(config==null) {
            config = new Config();
        }
        config.setName(nm);
        config.setPassword(pw);
    }

    public void syncConfigToZk() {
        ZkClient zk = new ZkClient("42.193.119.60:2181");
        if (!zk.exists("/zkConfig")) {
            zk.createPersistent("/zkConfig", true);
        }
        zk.writeData("/zkConfig", config);
        zk.close();
    }
}
