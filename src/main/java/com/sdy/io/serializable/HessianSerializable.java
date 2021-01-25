package com.sdy.io.serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author: sundy
 * @date: 2021/1/21 18:10
 * @description:
 */
public class HessianSerializable {

    public static void main(String[] args) throws IOException {
        Student student = new Student();
        student.setId(2);
        student.setName("hessian");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(bos);
        output.writeObject(student);
        output.flushBuffer();
        byte[] data = bos.toByteArray();
        bos.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        Hessian2Input input = new Hessian2Input(bis);
        Student deStudent = (Student) input.readObject();
        input.close();

        System.out.println(deStudent.toString());
    }
}
