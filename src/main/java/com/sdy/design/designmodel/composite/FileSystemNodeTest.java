package com.sdy.design.designmodel.composite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: SunDeYu
 * @date: 2020/9/1 14:57
 * @description:
 */
public class FileSystemNodeTest {
    private String path;
    private boolean isFile;
    private List<FileSystemNodeTest> subNodes = new ArrayList<>();

    public FileSystemNodeTest(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {
        if (isFile) {
            return 1;
        }
        int numOfFiles = 0;
        for (FileSystemNodeTest fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    public long countSizeOfFiles() {
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) {
                return 0;
            }
            return file.length();
        }
        long sizeOfFiles = 0;
        for (FileSystemNodeTest fileOrDir : subNodes) {
            sizeOfFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public String getPath() {
        return path;
    }

    public void addSubNode(FileSystemNodeTest fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNodeTest fileOrDit) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDit.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
