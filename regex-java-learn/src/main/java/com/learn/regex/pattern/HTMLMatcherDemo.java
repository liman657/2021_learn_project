package com.learn.regex.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * autor:liman
 * createtime:2021/9/28
 * comment:匹配HTML的实例
 */
@Slf4j
public class HTMLMatcherDemo {

    public static void main(String[] args) {
        String htmlTxt = "<font face=\"Arial,Serif\" size=\"+2\" color=\"red\">";

        Pattern pattern = Pattern.compile("<\\s*font\\s*([^>]*)\\s*>");

        Matcher matcher = pattern.matcher(htmlTxt);
        matcher.find();
        String attribute = matcher.group(1);
        log.info("正则匹配到的数据为:{}",attribute);
        Pattern nextPattern = Pattern.compile("([a-z]+)\\s*=\\s*\"([^\"]+)\"");
        Matcher nextMatcher = nextPattern.matcher(attribute);
        while(nextMatcher.find()){
            log.info("属性名称:{},属性值:{}",nextMatcher.group(1),nextMatcher.group(2));
        }


    }

}
