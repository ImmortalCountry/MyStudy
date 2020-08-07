package com.sdy.others;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author: SunDeYu
 * @date: 2020/8/6 10:29
 * @description:
 */
public class PeopleAnnotationUtil {
    private static StringBuilder sb = new StringBuilder("名字：");
    public static void getFruitInfo(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(PeopleAnnotation.class)){
                PeopleAnnotation fieldAnnotation = field.getAnnotation(PeopleAnnotation.class);
                StringBuilder str = sb.append(fieldAnnotation.value());
                System.out.println(str.toString());
            }
        }
    }
}
