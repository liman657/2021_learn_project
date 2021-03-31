package com.learn.redisson.common;

import java.text.SimpleDateFormat;

/**
 * autor:liman
 * createtime:2021/3/20
 * comment: Redisson的key
 */
public class RedisKeyConstant {

    /** bucket的key */
    public static final String BUCKET_USER_INFO_KEY = "Redisson:Bucket:User:";

    /** topic email的key */
    public static final String REDISSON_TOPIC_EMAIL_KEY = "Redisson:Email:Topic:Key:";

    public static final String REDISSON_BLOOM_ITEM_KEY = "Redisson:Bloom:Item:Key";

    /**rate limiter的key*/
    public static final String REDISSON_RATE_LIMITER_KEY = "Redisson:Rate:Limiter:Key";

    /** 普通map的key */
    public static final String REDISSON_ORDINAL_MAP_KEY = "Redisson:Ordinal:Map:Key";

    /** localCacheMap的key */
    public static final String  REDISSON_LOCAL_CACHE_MAP_KEY = "Redisson:Local:Cache:Map:Key";

    /** MapCache 的key */
    public static final String  REDISSON_MAP_CACHE_KEY = "Redisson:Map:Cache:Key";

    public static final SimpleDateFormat DATE_TIME_FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String REDISSON_MAP_CACHE_MAIL_KEY="Redisson:Map:Cache:Mail:Send";
}
