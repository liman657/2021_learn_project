package com.learn.redisson.server;

import java.util.Set;

/**
 * autor:liman
 * createtime:2021/3/24
 * comment: 插入数据的service
 */
public interface IDataService {

    public void insertBatch(Set<String> set);

}
