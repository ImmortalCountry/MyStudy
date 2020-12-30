package com.sdy.middleware.zookeeper.configcenter1;

import java.io.Serializable;

/**
 * @author: sundy
 * @date: 2020/12/29 16:07
 * @description:
 */
public class Config implements Serializable {

    private static final long serialVersionUID = -2221029753974305448L;

    private String name;
    private String password;

    public Config() {
    }

    public Config(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Config{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
