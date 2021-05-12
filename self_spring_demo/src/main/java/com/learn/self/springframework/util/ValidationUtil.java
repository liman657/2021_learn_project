package com.learn.self.springframework.util;

import java.util.Collection;

/**
 * autor:liman
 * createtime:2021/5/11
 * comment:校验工具类
 */
public class ValidationUtil {

    /**
     * String是否为null或""
     *
     * @param obj String
     * @return 是否为空
     */
    public static boolean isEmpty(String obj) {
        return (obj == null || "".equals(obj));
    }

    /**
     * 集合的判空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

    /**
     * Array是否为null或者size为0
     *
     * @param obj Array
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] obj) {
        return obj == null || obj.length == 0;
    }

}
