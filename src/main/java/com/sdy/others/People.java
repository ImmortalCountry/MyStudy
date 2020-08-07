package com.sdy.others;

import lombok.Data;

/**
 * @author: SunDeYu
 * @date: 2020/8/7 11:42
 * @description:
 */
@Data
public class People {
    @PeopleAnnotation("测试名字")
    private String name;
}
