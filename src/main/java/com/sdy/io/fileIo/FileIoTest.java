package com.sdy.io.fileIo;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author: SunDeYu
 * @date: 2020/8/9 18:35
 * @description:
 */
public class FileIoTest {
    private static String String;

    public static void main(String[] args) {
//        TestPath();
        // 字节
        String readerPath = FileIoTest.class.getClassLoader().getResource("fileReader.txt").getPath();
        String writePath = FileIoTest.class.getClassLoader().getResource("fileWrite.txt").getPath();

        bytesFileTest(readerPath, writePath);

    }

    private static void TestPath(){
        ClassLoader classLoader = FileIoTest.class.getClassLoader();
        URL path1 = classLoader.getResource("logback.xml");
//        URL path2 = classLoader.getResource("/logback.xml");
        System.out.println(path1);
        System.out.println(FileIoTest.class.getResource(""));
        System.out.println(FileIoTest.class.getResource("/"));
    }

    /**
     * 会写在 classes文件中
     * @param readerPath
     * @param writePath
     */
    private static void bytesFileTest(java.lang.String readerPath, java.lang.String writePath) {
        FileOutputStream out = null;
        FileInputStream in = null;
        String str = "测试字节文件的读写";
        try{
            out = new FileOutputStream(new File("reader.txt"));
            in = new FileInputStream(new File("reader.txt"));
            byte[] bufferReader = new byte[20 * 1024];
            byte[] bufferWrite = str.getBytes();
            out.write(bufferWrite);
            out.flush();
            int cnt = 0;
            in = new FileInputStream(new File(readerPath));
            while((cnt = in.read(bufferReader, 0, bufferReader.length)) != -1){
               String context = new String(bufferReader);
                System.out.println(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null){
                try{
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}



