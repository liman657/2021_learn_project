package com.learn.regex.helloworld;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * autor:liman
 * createtime:2021/9/24
 * comment:
 */
@Slf4j
public class MatcherGroupTest {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(ca)(t)");
        Matcher matcher = pattern.matcher("one cat,two cats in the yard");
        StringBuffer stringBuffer = new StringBuffer();
        boolean result = matcher.find();
        log.info("此次查询得到的组数量为：{}", matcher.groupCount());
        for (int i=1; i <= matcher.groupCount(); i++) {
            log.info("第{}组的子串内容为:{}",i,matcher.group(i));
        }
        int replaceCount = 0;
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
