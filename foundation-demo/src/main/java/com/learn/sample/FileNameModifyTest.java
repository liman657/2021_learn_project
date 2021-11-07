package com.learn.sample;

import java.io.File;
import java.io.IOException;

/**
 * 文件路径递归创建
 */
public class FileNameModifyTest {

    public static void main(String[] args) {
        String fileName = "F:\\blog_doc\\博客文档\\debug分布式锁\\git使用（一）——git基础.md";
        String replaceFileName = fileName.replace("F:\\blog_doc", "F:\\blog_doc_new");
        int splitIndex = replaceFileName.lastIndexOf("\\");
        String dirPath = replaceFileName.substring(0,splitIndex+1);
        String createFileName = replaceFileName.substring(splitIndex+1,replaceFileName.length());
        System.out.println(dirPath);
        System.out.println(createFileName);
        File dirFile = new File(dirPath);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        File file = new File(dirPath,createFileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(replaceFileName);
    }

}
