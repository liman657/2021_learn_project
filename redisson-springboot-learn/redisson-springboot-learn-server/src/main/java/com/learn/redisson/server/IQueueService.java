package com.learn.redisson.server;

import com.learn.redisson.module.entity.Notice;

/**
 * autor:liman
 * createtime:2021/4/7
 * comment:
 */
public interface IQueueService {

    public int createNotice(Notice notice);

}
