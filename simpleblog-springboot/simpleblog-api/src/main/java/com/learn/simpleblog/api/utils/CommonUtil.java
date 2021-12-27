package com.learn.simpleblog.api.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @Author:debug (SteadyJack) wx：debug0868
 */
public class CommonUtil {

    public static String randomUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 分隔后拼接成用于sql查询的字符串- 'a','b','c'  "a,b,c"
     * @param param
     * @param separatorChars
     * @return
     */
    public static String concatStrToChar(String param, String separatorChars){
        StringBuilder sb=new StringBuilder();
        String[] arr= StringUtils.split(param,separatorChars);
        int i=0;
        for (;i<arr.length;i++){
            if (arr.length-1 != i){
                sb.append("'").append(arr[i]).append("'").append(",");
            }else{
                sb.append("'").append(arr[i]).append("'");
            }
        }
        return sb.toString();
    }

    /**
     * 分隔后拼接成用于sql查询的字符串- a,b,c
     * @param param
     * @param separatorChars
     * @return
     */
    public static String concatStrToInt(String param, String separatorChars){
        StringBuilder sb=new StringBuilder();
        String[] arr= StringUtils.split(param,separatorChars);
        int i=0;
        for (;i<arr.length;i++){
            if (arr.length-1 != i){
                sb.append(arr[i]).append(",");
            }else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /*public static void main(String[] args) {
        *//*Constant.MsgModule[] arr=Constant.MsgModule.values();
        int length=arr.length;
        for (int i=0;i<length;i++){
            System.out.println(arr[i].getCode()+"---"+arr[i].getMsg());

        }*//*

        *//*ConcurrentHashMap<String,String> hashMap=new ConcurrentHashMap<>();
        hashMap.put("2010","修罗");
        hashMap.put("2011","debug");

        Set<Map.Entry<String,String>> set=hashMap.entrySet();
        set.forEach(entry -> System.out.println(entry.getKey()+" -- "+entry.getValue()));*//*

        StringBuffer sb=new StringBuffer("22,23,24,25,26,27,28,29,30,31,32,33,34,");
        String res=sb.reverse().toString().replaceFirst(",","").toString();
        System.out.println(res);
    }*/
}






















