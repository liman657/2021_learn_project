package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

/**
 * autor:liman
 * createtime:2021/3/20
 * comment: 实现ApplicationRunner接口和Ordered接口，完成对于redisson中topic的监听
 *
 */
@Service("topicConsumerService")
@Slf4j
public class TopicConsumerService implements ApplicationRunner,Ordered {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("--跟随项目启动，不断监听并处理消费者数据--");
        this.listenTopicData();
    }

    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * 监听并处理topic中的数据
     */
    private void listenTopicData(){
        try{
            log.info("-----监听主题topic,并处理其中的数据-----");
            RTopic<String> mailTopic = redissonClient.getTopic(RedisKeyConstant.REDISSON_TOPIC_EMAIL_KEY);
//            mailTopic.addListener((charSequence,s)->{
//               log.info("从topic中读取的信息为:{}",s);
//            });
        }catch (Exception e){
            log.error("-----监听主题，处理数据出现异常-----");
        }
    }
}
