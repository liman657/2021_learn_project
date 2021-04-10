package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.Notice;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * autor:liman
 * createtime:2021/4/7
 * comment:
 */
@Component
@Slf4j
public class RedissonQueueSchedulService {

    @Autowired
    private RedissonClient redissonClient;

    //http://www.fightjava.com/web/index/blog/article/39
    //cron表达式，每一秒调用一次该逻辑
    @Scheduled(cron="0/1 * * * * ?")
    @Async
    public void manageNotice(){
        try{
            //从queue中取数据，然后进行处理
            RQueue<Notice> rQueue = redissonClient.getQueue(RedisKeyConstant.REDISSON_QUEUE_REDIS_KEY);
            if(null!=rQueue && !rQueue.isEmpty()){
                Notice notice = rQueue.poll();
                log.info("从queue中获取到的数据为:{},这里直接日志处理，模拟数据的消费",notice);
            }
        }catch (Exception e){
            log.error("处理队里中的消息出现异常，异常信息为:{}",e);
        }
    }
}