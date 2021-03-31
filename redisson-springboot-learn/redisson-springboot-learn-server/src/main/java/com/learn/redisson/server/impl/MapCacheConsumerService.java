package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.MailInfo;
import com.learn.redisson.module.mapper.MailInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.api.map.event.EntryEvent;
import org.redisson.api.map.event.EntryExpiredListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * autor:liman
 * createtime:2021/3/30
 * comment:map cache的监听服务
 */
@Service
@Slf4j
public class MapCacheConsumerService implements ApplicationRunner,Ordered {

    @Autowired
    private MailInfoMapper mailInfoMapper;
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("map cache 的监听服务 启动顺序：order-2");
        sendDelayEmail();
    }

    @Override
    public int getOrder() {
        return 2;
    }

    private void sendDelayEmail(){
        try{
            //针对延时MapCache中的过时数据发送，这里进行监听
            RMapCache<Integer, String> mapCache = redissonClient.getMapCache(RedisKeyConstant.REDISSON_MAP_CACHE_MAIL_KEY);
            mapCache.addListener(new EntryExpiredListener<Integer,String>() {
                @Override
                public void onExpired(EntryEvent<Integer, String> event) {
                    Integer key = event.getKey();
                    String value = event.getValue();
                    log.info("map cache中的过时事件被触发,key:{},value:{}",key,value);
                    //TODO:这里简单的通过日志进行邮件发送
                    MailInfo mailInfo = mailInfoMapper.selectByPrimaryKey(key);
                    log.info("延时发送的邮件信息:{}",mailInfo);
                }
            });
        }catch (Exception e){
            log.error("map cache监听任务处理出现异常，异常信息为:{}",e);
        }
    }
}
