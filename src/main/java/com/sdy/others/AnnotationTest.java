package com.sdy.others;

import lombok.Data;

/**
 * @author: SunDeYu
 * @date: 2020/8/6 10:29
 * @description:
 */
@Data
public class AnnotationTest {
    @MyTest("测试")
    private String str;
}
