package com.sdy.thread.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: sundy
 * @date: 2020/9/30 11:34
 * @description:
 */
@Data
@RequiredArgsConstructor
public class Item {
    final String name;
    int remaining = 1000;
    @ToString.Exclude
    ReentrantLock lock = new ReentrantLock();
}
