package com.sdy.io;

import java.io.File;

/**
 * @author: SunDeYu
 * @date: 2020/8/8 10:45
 * @description: 递归打印目录文件
 */
public class FileClassTest {
    public static void main(String[] args) {
        File path = new File(".");
        listAllFile(path);
    }

    public static void listAllFile(File dir){
        if (dir == null || !dir.exists()){
            return;
        }
        if (dir.isFile()){
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFile(file);
        }
    }
}
