package com.sdy.others;

/**
 * @author: SunDeYu
 * @date: 2020/8/6 23:33
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.sdy.others.AnnotationTest");
            MyTest annotation = aClass.getAnnotation(MyTest.class);
            System.out.println(annotation.annotationType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
