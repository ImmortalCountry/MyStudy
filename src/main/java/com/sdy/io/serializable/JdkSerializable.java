package com.sdy.io.serializable;

import java.io.*;

/**
 * @author: sundy
 * @date: 2021/1/21 17:26
 * @description:
 */
public class JdkSerializable{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String home = System.getProperty("user.home");
        String bashPath = home + "\\Desktop";
        FileOutputStream fos = new FileOutputStream(bashPath + "\\student_jdk.dat");
        Student student = new Student();
        student.setId(1);
        student.setName("jdk");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream(bashPath + "\\student_jdk.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student deStudent = (Student)ois.readObject();
        ois.close();
        System.out.println(deStudent);
    }
}
