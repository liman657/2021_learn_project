package com.learn.redisson.server;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 分布式对象的服务类
 */
public interface IRedissonTopicObjService {

    public void sendTopicEmail(final Integer userId);

}
