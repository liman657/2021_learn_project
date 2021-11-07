package com.learn.sample;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * autor:liman
 * createtime:2021-10-31
 * comment: 读取已经编写的markdown文档，并对指定字符进行正则替换
 * 测试正则匹配替换
 */
@Slf4j
public class MatcherReplaceTest {

    public static void main(String[] args) throws IOException {
        String content = "![image-20210227180527076](E:\\blogPic\\kafka_learn\\image-20210227180527076.png)";
        String regex = "E{1}\\:\\\\blogPic\\b";
        String toReplaceStr = "F:\\\\blog_doc\\\\blogPic";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        String replaceResult = content.replaceAll(regex, toReplaceStr);
        System.out.println(replaceResult);
    }


}
