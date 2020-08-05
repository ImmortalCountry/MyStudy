package com.sdy.test;

import com.google.common.collect.Lists;
import com.sdy.callBack.BookCallBack;
import com.sdy.callBack.ICallBack;
import org.junit.Test;

import java.util.List;

/**
 * @author: sundy
 * @date: 2020/4/28 22:30
 * @description:
 */
public class Main {

    @Test
    public void main(){
//        TestBookCallBack testBookCallBack = new TestBookCallBack();
//        testBookCallBack.test(new ICallBack() {
//            @Override
//            public void execute() {
//                System.out.println("Anonymous Inner Class");
//            }
//        });
//        BookCallBack bookCallBack = new BookCallBack();
//        testBookCallBack.test(bookCallBack);
        List<String> tentands = Lists.newArrayList("1","2","3","4","5","6");
        List<String> re = Lists.newArrayList("2","4","6");
        tentands.parallelStream().forEach(t->{
            if (re.contains(t)){
                return;
            }
            System.out.println(t);
        });

    }

}
