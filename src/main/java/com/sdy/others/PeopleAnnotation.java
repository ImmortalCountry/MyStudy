package com.sdy.others;

import java.lang.annotation.*;

/**
 * @author: SunDeYu
 * @date: 2020/8/6 10:31
 * @description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PeopleAnnotation {
    String value() default "默认值";
}


