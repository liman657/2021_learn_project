package com.learn.self.springframework.util;

import java.util.Collection;

/**
 * autor:liman
 * createtime:2021/5/11
 * comment:校验工具类
 */
public class ValidationUtil {

    /**
     * 集合的判空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

}
