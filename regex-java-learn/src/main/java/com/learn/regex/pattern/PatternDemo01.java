package com.learn.regex.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * autor:liman
 * createtime:2021/9/24
 * comment:演示简单的字母匹配
 */
@Slf4j
public class PatternDemo01 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        matchCatWord();
        matchTNWord();
        matchNotOne();
        matchOrPattern();
        matchNumCount();
        matchNumCountOr();
    }

    /**
     * 设置匹配模式：[a-zA-Z]*[cC]{1,}[aA]{1,}[tT]{1,}[a-zA-Z]*
     * [a-zA-Z]*：表示可以由字母开头，出现0次、1次或多次
     * [cC]{1,}：表示c或C至少出现一次
     * [aA]{1,}：表示a或A至少出现一次
     * [tT]{1,}：表示t或T至少出现一次
     * [a-zA-Z]*：表示可以由字母结尾，出现0次、1次或多次
     */
    public static void matchCatWord(){
        String txt = "catalog";
        Pattern pattern = Pattern.compile("[a-zA-Z]*[cC]{1,}[aA]{1,}[tT]{1,}[a-zA-Z]*");
        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){//测试是否匹配
            log.info("【匹配cat】匹配成功");
        }else{
            log.warn("【匹配cat】匹配失败");
        }
    }

    public static void matchTNWord(){
        String txt = "t*n";
        Pattern pattern = Pattern.compile("t.n");//* 表示任意字母
        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){//测试是否匹配
            log.info("【匹配t.n】匹配成功");
        }else{
            log.warn("【匹配t.n】匹配失败");
        }
    }

    public static void matchNotOne() {
        String txt = "t0n";
        Pattern pattern = Pattern.compile("t[aeio]n");
        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){//测试是否匹配
            log.info("【匹配t[aeio]n】匹配成功");
        }else{
            log.warn("【匹配t[aeio]n】匹配失败");
        }
    }

    public static void matchOrPattern(){
        String txt = "toon";
        Pattern pattern = Pattern.compile("t(a|e|i|o|oo)n");//这里不能用[]，因为[]是针对单个字符，不是针对多个字符
        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){//测试是否匹配
            log.info("【匹配t|n】匹配成功");
        }else{
            log.warn("【匹配t|n】匹配失败");
        }
    }

    /**
     * 匹配数字出现的次数
     */
    public static void matchNumCount(){
        String txt = "123-89-9999";
        Pattern pattern = Pattern.compile("[0-9]{3}\\-[0-9]{2}\\-[0-9]{4}");
        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){//测试是否匹配
            log.info("【匹配电话号码】匹配成功");
        }else{
            log.warn("【匹配电话号码】匹配失败");
        }
    }

    /**
     * 匹配数字出现的次数【连接符号可选】
     */
    public static void matchNumCountOr(){
        String txt = "123899999";
        Pattern pattern = Pattern.compile("[0-9]{3}\\-?[0-9]{2}\\-?[0-9]{4}");
        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){//测试是否匹配
            log.info("【匹配电话号码(连接符号可选)】匹配成功");
        }else{
            log.warn("【匹配电话号码(连接符号可选)】匹配失败");
        }
    }

}
