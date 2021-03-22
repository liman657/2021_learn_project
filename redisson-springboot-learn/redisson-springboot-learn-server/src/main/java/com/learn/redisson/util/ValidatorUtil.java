package com.learn.redisson.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 请求参数的统一校验器
 * @Author:debug (SteadyJack)
 * @Link: weixin-> debug0868 qq-> 1948831260
 * @Date: 2019/12/24 14:34
 **/
public class ValidatorUtil {

    //统一校验前端的请求参数
    public static String checkResult(BindingResult result){
        StringBuffer sb=new StringBuffer("");
        if (result!=null && result.hasErrors()){
            List<ObjectError> list=result.getAllErrors();
            for (ObjectError error:list){
                sb.append(error.getDefaultMessage()).append("\n");
            }
        }

        return sb.toString();
    }

}