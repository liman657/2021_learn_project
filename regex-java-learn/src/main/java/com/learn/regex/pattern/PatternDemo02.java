package com.learn.regex.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * autor:liman
 * createtime:2021/9/24
 * comment:正则表达式简单实例02
 */
@Slf4j
public class PatternDemo02 {

    public static void main(String[] args) {
        matcherNumAndAlp();
        matcherNagative();
        matcherDate();
        matcherSimpleRegex();
    }

    /**
     * 匹配简单的车牌号
     */
    public static void matcherNumAndAlp(){
        String txt = "1234CA";
        Pattern pattern = Pattern.compile("[0-9]{4}[A-Z]{2}");
        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){//测试是否匹配
            log.info("【车牌号】匹配成功");
        }else{
            log.warn("【车牌号】匹配失败");
        }
    }

    /**
     * 匹配 否 符号
     */
    public static void matcherNagative(){
        String txt = "cat";
        Pattern pattern = Pattern.compile("^[^X][a-z]+$");
        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){
            log.info("取非的判断匹配成功");
        }else{
            log.warn("取非的判断失败");
        }
    }

    public static void matcherDate(){
        String dateTxtOne = "june 26, 1992";
        /**
         * [a-z]表示字母的范围
         * \\s表示空格
         * \\s*表示空格可选
         * [0,9]{1,2}表示出现数字1~2次
         * [0,9]{4}表示出现数字4次
         */
        Pattern patternOne = Pattern.compile("[a-z]+\\s+[0-9]{1,2},\\s*[0-9]{4}");
        Matcher matcher = patternOne.matcher(dateTxtOne);
        if(matcher.matches()){
            log.info("日期简单判断成功");
        }else{
            log.warn("日期简单判断失败");
        }
    }

    public static void matcherSimpleRegex(){
        String txt = "123-236789";
        /**
         * \\d:表示[0-9]
         * {n}:表示出现的次数
         * ？:表示出现一次或者0次 \\-?表示-出现1次或者0次
         */
        Pattern pattern = Pattern.compile("\\d{3}\\-?\\d{2}\\-?\\d{4}");

        Matcher matcher = pattern.matcher(txt);
        if(matcher.matches()){
            log.info("【简单的模式】匹配成功");
        }else{
            log.warn("【简单的模式】匹配失败");
        }
    }

}
