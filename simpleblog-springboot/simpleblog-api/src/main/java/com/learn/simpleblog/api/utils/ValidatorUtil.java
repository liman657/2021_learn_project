package com.learn.simpleblog.api.utils;

import org.springframework.validation.BindingResult;

/**
 * 请求参数统一校验工具
 * @Author:debug (SteadyJack) - wx:debug0868
 **/
public class ValidatorUtil {

    //统一处理校验的结果
    public static String checkResult(BindingResult result){
        StringBuilder sb=new StringBuilder("");

        if (result!=null && result.hasErrors()){
            /*List<ObjectError> errors=result.getAllErrors();
            for (ObjectError error:errors){
                sb.append(error.getDefaultMessage()).append("\n");
            }*/

            //java8 stream写法
            result.getAllErrors().stream().forEach(error -> sb.append(error.getDefaultMessage()).append("\n"));
        }

        return sb.toString();
    }

}