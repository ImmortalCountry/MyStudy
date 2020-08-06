package com.sdy.reflect;

import ch.qos.logback.core.encoder.EchoEncoder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: SunDeYu
 * @date: 2020/8/6 21:57
 * @description:
 */
public class ReflectClass {
    public static final String TAG = "peter.log.ReflectClass";

    /**
     * 创建对象
     */
    public static void reflectNewInstance() {
        try {
            Class<?> classStudent = Class.forName("com.sdy.reflect.Student");
            Student student = (Student) classStudent.newInstance();
            student.setName("小明");
            student.setAge("18");
            System.out.println("reflectNewInstance student = " + student.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 反射私有构造方法
     */
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classStudent = Class.forName("com.sdy.reflect.Student");
            Constructor<?> declaredConstructor = classStudent.getDeclaredConstructor(String.class, String.class);
            declaredConstructor.setAccessible(true);
            Student student = (Student) declaredConstructor.newInstance("私有构造", "20");
            System.out.println("reflectPrivateConstructor Student" + student.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * 反射私有属性
     */
    public static void reflectPrivateField() {
        try {
            Class<?> classStudent = Class.forName("com.sdy.reflect.Student");
            Object o = classStudent.newInstance();
            Field field = classStudent.getDeclaredField("TAG");
            // 抑制安全访问检查
            field.setAccessible(true);
            // 获得obj中对应的属性值
            String tag = (String) field.get(o);
            System.out.println("reflectPrivateField tag = " + tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void reflectMethod() {
        try {
            Class<?> classStudent = Class.forName("com.sdy.reflect.Student");
            Method method = classStudent.getDeclaredMethod("declaredMethod", int.class);
            method.setAccessible(true);
            Object student = classStudent.newInstance();
            String string = (String) method.invoke(student, 0);
            System.out.println(string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void testClassLoader(){
        try {
            Class<?> classStudent = Class.forName("com.sdy.reflect.Student");
            System.out.println("=================");
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.sdy.reflect.Student");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
