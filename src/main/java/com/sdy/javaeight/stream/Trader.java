package com.sdy.javaeight.stream;

import lombok.Data;

/**
 * @author: sundy
 * @date: 2020/5/15 15:19
 * @description:
 */
@Data
public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }
}
