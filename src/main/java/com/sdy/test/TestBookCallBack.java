package com.sdy.test;

import com.sdy.callBack.ICallBack;

/**
 * @author: sundy
 * @date: 2020/4/28 22:28
 * @description:
 */
public class TestBookCallBack {
    public void test(ICallBack callBack){
        // 1. 处理业务
        System.out.println("——————————业务处理 TestCallBack————————");
        // 2. 执行回调函数
        callBack.execute();
    }

}
