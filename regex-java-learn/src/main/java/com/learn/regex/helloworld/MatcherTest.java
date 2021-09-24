package com.learn.regex.helloworld;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * autor:liman
 * createtime:2021/9/24
 * comment:Matcher的test类
 */
@Slf4j
public class MatcherTest {

    public static void main(String[] args) {
        //生成pattern对象，并且编译一个简单的正则表达式"Kevin"
        Pattern pattern = Pattern.compile("Kevin");
        //用Pattern的matcher方法生成一个Matcher对象
        Matcher matcher = pattern.matcher("Kevin Li and Kevin Chan are both working in Kevin Chen's KevinSoftShop company");
        StringBuffer stringBuffer = new StringBuffer();
        int replaceCount = 0;
        boolean result = matcher.find();//find方法查找到第一个对象
        //使用循环将文本中所有匹配的内容进行处理
        while(result){
            replaceCount++;
            matcher.appendReplacement(stringBuffer, "Coder");
            log.info("第{}次替换后的内容是：{}",replaceCount,stringBuffer);
            result = matcher.find();
        }
        matcher.appendTail(stringBuffer);
        log.info("全部替换完成之后的结果为:{}",stringBuffer);

    }

}
