package com.sdy.thread.threadpool;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: sundy
 * @date: 2021/1/29 10:53
 * @description: 自定义线索池实现类
 */
public class CustomizeThreadPool implements CustomizeExecutor {
    List<Runnable> worker = Lists.newArrayList();

    @Override
    public void execute(Runnable r) {
        if (r != null) {
            worker.add(r);
        }
    }
}
