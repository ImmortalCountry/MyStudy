package com.sdy.copy;

import lombok.Data;

/**
 * @author: SunDeYu
 * @date: 2020/8/20 10:30
 * @description:
 */
@Data
public class CopyObject implements Cloneable{
    private String name;
    private Integer age;
//    private ReferenceObject reference;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

