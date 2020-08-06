package com.sdy.reflect;

import lombok.Data;

/**
 * @author: SunDeYu
 * @date: 2020/8/6 14:58
 * @description:
 */

public class Student {
    public static final String TAG = "StudentTag";

    private String name;
    private String age;

    static {
        System.out.println("执行静态代码块");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Student() {

    }

    private Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public static String getTAG() {
        return TAG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 1 !";
                break;
            case 1:
                string = "I am declaredMethod 2 !";
                break;
            default:
                string = "I am declaredMethod 1 !";
        }
        return string;
    }
}
