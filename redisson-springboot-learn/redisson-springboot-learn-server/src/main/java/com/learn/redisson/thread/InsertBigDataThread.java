package com.learn.redisson.thread;

import cn.hutool.core.lang.Snowflake;
import com.google.common.collect.Sets;
import com.learn.redisson.server.IDataService;

import java.util.Set;
import java.util.concurrent.Callable;

/**
 * autor:liman
 * createtime:2021/3/24
 * comment: 增加大量数据的线程
 */
public class InsertBigDataThread implements Callable<Boolean> {

    private static final Snowflake snowFlake = new Snowflake(3,2);

    private IDataService dataService;

    public InsertBigDataThread(IDataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public Boolean call() throws Exception {
        if(null!=dataService) {

            Set<String> set = Sets.newHashSet();
            for (int i = 0; i < 10000; i++) {
                set.add(snowFlake.nextIdStr());
            }
            dataService.insertBatch(set);
        }
        return true;
    }
}
