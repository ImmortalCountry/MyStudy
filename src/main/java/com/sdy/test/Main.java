package com.sdy.test;

import com.sdy.callBack.ICallBack;
import org.junit.Test;

/**
 * @author: sundy
 * @date: 2020/4/28 22:30
 * @description:
 */
public class Main {

    @Test
    public void main(){
        TestBookCallBack testBookCallBack = new TestBookCallBack();
        testBookCallBack.test(new ICallBack() {
            @Override
            public void execute() {
                System.out.println("Anonymous Inner Class");
            }
        });
    }

}
