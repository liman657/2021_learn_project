package com.learn.sample;

import java.io.File;
import java.util.LinkedList;

/**
 * autor:liman
 * createtime:2021-10-31
 * comment:
 */
public class FileVideoTimeLengthCal {

    public static void main(String[] args) {
        String filePath = "E:\\自我学习\\33 算法面试通关40讲";
        readFileDirFile(filePath);
    }


    public static void readFileDirFile(String path){
        LinkedList<File> Dirlist = new LinkedList<File>();
        LinkedList<String> Filelist = new LinkedList<String>();
        File dir = new File(path);
        File[] files = dir.listFiles();

        for(File file : files){
            if(file.isDirectory()){
                Dirlist.add(file);
            }else{
                //处理文件内容
                Filelist.add(file.getAbsolutePath());
                System.out.println(file.getAbsolutePath());
            }
        }

        File temp;
        while(!Dirlist.isEmpty()){
            temp = Dirlist.removeFirst();
            if(temp.isDirectory()){
                files = temp.listFiles();
                if(files == null) continue;
                for(File file : files){
                    if(file.isDirectory()){
                        Dirlist.add(file);
                    }else{
                        //处理文件内容
                        Filelist.add(file.getAbsolutePath());
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }else{
                //处理文件内容,这种情况好像不会发生
                System.out.println("-------------");
            }
        }
    }

}
