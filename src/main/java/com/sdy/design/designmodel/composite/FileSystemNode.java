package com.sdy.design.designmodel.composite;

import java.nio.file.FileSystem;

/**
 * @author: SunDeYu
 * @date: 2020/9/1 15:18
 * @description:
 */
public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path){
        this.path = path;
    }

    /**
     * 文件数目
     * @return
     */
    public abstract int countNumOfFiles();

    /**
     * 文件大小
     * @return
     */
    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}
