package com.sdy.io.serializable;

import java.io.Serializable;

/**
 * @author: sundy
 * @date: 2021/1/21 18:12
 * @description:
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -5265610969758210183L;
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JdkSerializable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
