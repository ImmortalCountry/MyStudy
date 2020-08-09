package com.sdy.io.fileIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: SunDeYu
 * @date: 2020/8/9 21:04
 * @description:
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        String str = "123";
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
