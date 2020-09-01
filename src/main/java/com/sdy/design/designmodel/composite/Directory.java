package com.sdy.design.designmodel.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: SunDeYu
 * @date: 2020/9/1 15:26
 * @description:
 */
public class Directory extends FileSystemNode {
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeofFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.path)) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
