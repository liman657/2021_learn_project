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

    /**
     * 批量插入数据到数据库
     * @throws Exception
     */
    public void genDataByThread() throws Exception;

    /**
     * 判断是否存在于大数据集合中
     * @param itemCode
     * @return
     */
    public boolean isInBigData(final String itemCode);

}
