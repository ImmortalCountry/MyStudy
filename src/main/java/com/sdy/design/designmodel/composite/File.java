package com.sdy.design.designmodel.composite;

/**
 * @author: SunDeYu
 * @date: 2020/9/1 15:20
 * @description:
 */
public class File extends FileSystemNode {

    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }
}
