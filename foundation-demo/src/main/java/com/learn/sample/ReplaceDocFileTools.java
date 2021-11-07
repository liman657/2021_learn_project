package com.learn.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * autor:liman
 * createtime:2021-10-31
 * comment: 读取已经编写的markdown文档，并对指定字符进行正则替换
 */
@Slf4j
public class ReplaceDocFileTools {

    private static Set<String> markDownFileSuffix = new HashSet<>();

    private static Integer count = 0;

    static {
        //只处理md文件
        markDownFileSuffix.add("md");
    }

    public static void main(String[] args) throws IOException {

        String path = "F:\\blog_doc\\博客文档";
        //1.读取文件夹下的所有视频文件
        List<File> fileList = new ArrayList<>();
        readFileInDir(path, fileList);
        List<String> fileNameList = fileList.stream().map(File::getName).collect(Collectors.toList());
        log.info("得到的文件列表为:");
        fileNameList.stream().forEach(t -> System.out.println(t));
        log.info("待转换的文件个数为:{}",fileNameList.size());
        String toRegexStr = "E{1}\\:\\\\blogPic\\b";
        String toReplaceStr = "F:\\\\blog_doc\\\\blogPic";
        fileList.stream().forEach(t -> replaceImgPath(t, toRegexStr, toReplaceStr));
        log.info("批量文件字符串替换完成，原始文件个数:{}，总共替换字符串:{}个",fileNameList.size(),count);
    }

    /**
     * 递归读取文件夹下的所有文件
     *
     * @param path
     */
    public static void readFileInDir(String path, List<File> fileList) {
        File f = new File(path);
        //得到文件下的所有文件
        File[] files = f.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                readFileInDir(file.getAbsolutePath(), fileList);
            } else {
                if (isMarkDownFile(file.getName())) {
                    fileList.add(file);
                }
            }
        }
    }

    /**
     * 判断是否是markdown文档
     *
     * @param fileName
     * @return
     */
    public static boolean isMarkDownFile(String fileName) {
        boolean result = false;
        String suffix = fileName.substring(fileName.lastIndexOf('.') + 1);
        if (markDownFileSuffix.contains(suffix)) {
            result = true;
        }
        return result;
    }

    /**
     * 开始替换文件中的内容
     *
     * @param sourceFile
     */
    public static void replaceImgPath(File sourceFile, String targetRegex, String toReplaceStr) {
        String regex = targetRegex;
        String targetFileDir = "F:\\博客文档_新";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        log.info("开始处理文件:{},最终文件会存在目录:{}中",sourceFile.getAbsoluteFile(),targetFileDir);
        String fileName = sourceFile.getAbsoluteFile() + "/" + sourceFile.getName();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
            File targetFile = createTargetFile(sourceFile,targetFileDir);
            if(null == targetFile){
                log.info("文件:{},目标文件创建失败，请手动操作",sourceFile.getAbsolutePath());
                return;
            }
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile)));
            String tempStr = "";
            String regStr = regex;
            Pattern pattern = Pattern.compile(regStr);
            while ((tempStr = reader.readLine()) != null) {
                tempStr += "\n"; //加上换行，避免格式错乱
                Matcher matcher = pattern.matcher(tempStr);
                if (matcher.find()) {//如果匹配上
                    tempStr = tempStr.replaceAll(regex, toReplaceStr);
                    log.info("文件:{},替换后的字符串为:{}",sourceFile.getAbsoluteFile(), tempStr);
                    count++;
                }
                writer.write(tempStr);
            }
            writer.flush();
        } catch (Exception e) {
            log.error("文件:{},字符替换异常，请手动操作", fileName);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                log.error("文件:{},流关闭异常", fileName);
            }
            try {
                writer.close();
            } catch (IOException e) {
                log.error("文件:{},流关闭异常", fileName);
            }
        }
    }

    public static File createTargetFile(File sourceFile,String targetFileDir){
        String sourceFileAbsoluteName = sourceFile.getAbsolutePath();
        String afterDealFileName = sourceFileAbsoluteName.replace("F:\\blog_doc", targetFileDir);
        int splitIndex = afterDealFileName.lastIndexOf("\\");
        String dirPath = afterDealFileName.substring(0,splitIndex+1);
        String createFileName = afterDealFileName.substring(splitIndex+1);
        log.info("准备创建的目标文件名为:{},存在于:{}文件夹",createFileName,dirPath);
        File dirFile = new File(dirPath);
        if(!dirFile.exists()){
            dirFile.mkdirs();
            log.info("文件夹:{}创建完成",dirPath);
        }
        File targetFile = new File(dirPath,createFileName);
        if(!targetFile.exists()){
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                log.error("文件:{}创建异常:{}",targetFile.getAbsolutePath(),e);
                return null;
            }
            log.info("文件:{}创建完成",targetFile.getAbsolutePath());
        }
        return targetFile;


    }
}