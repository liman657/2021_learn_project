package com.learn.regex.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * autor:liman
 * createtime:2021/9/28
 * comment: 分析一个Web服务器日志文件，确定每一个用户花在网站上的时间
 * 注意分组符号的作用
 */
@Slf4j
public class WebLogInfoDemo {

    public static void main(String[] args) {
        String ipTxt = "123.897.823.22";
        Pattern pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");//简单的匹配ip地址
        Matcher matcher = pattern.matcher(ipTxt);
        if(matcher.matches()){
            log.info("简易IP匹配成功");
        }else{
            log.warn("简易IP匹配失败");
        }

        String simpleLogTxt = "123.897.823.22 -- [26/Feb/2001:10:56:03 -0500] \"GET /IsAlive.html HTTP/1.0\" 200 15";
        /**
         * (\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}) -- 匹配前面的ip地址
         * \\s\\-\\-\\s 匹配 " -- "
         * \\[([^]]+)\\]\\s 匹配"[26/Feb/2001:10:56:03 -0500] "
         * \"\\w* /[\\w.\\s/]*\"\\s\\d*\\s\\d* 匹配 "\"GET /IsAlive.html HTTP/1.0\"
         * \\s\\d*\\s\\d* 匹配 " 200 15"
         */
        Pattern patternLog = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})\\s\\-\\-\\s" +
                "\\[([^]]+)\\]\\s\"\\w* /[\\w.\\s/]*\"\\s\\d*\\s\\d*");
        Matcher logMatcher = patternLog.matcher(simpleLogTxt);
        //if(logMatcher.matches()){
        //    log.info("复杂日志匹配成功");
        //}else{
        //    log.warn("复杂日志匹配失败");
        //}

        boolean findResult = logMatcher.find();
        log.info("matcher find result:{}，count:{}",findResult,logMatcher.groupCount());
        log.info("ip地址:{}",logMatcher.group(1));
        log.info("时间:{}",logMatcher.group(2));

    }

}
