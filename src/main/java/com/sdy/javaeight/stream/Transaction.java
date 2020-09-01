package com.sdy.javaeight.stream;

import lombok.Data;

/**
 * @author: sundy
 * @date: 2020/5/15 15:25
 * @description:
 */
@Data
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
}
