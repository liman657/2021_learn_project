package com.learn.redisson.server;

import com.learn.redisson.module.entity.Item;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 分布式对象的服务类
 * 布隆过滤器的service接口
 */
public interface IRedissonBloomObjService {

    public Integer addItem(Item item);

}
