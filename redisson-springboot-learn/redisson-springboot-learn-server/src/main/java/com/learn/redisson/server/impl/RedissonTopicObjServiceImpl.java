package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.User;
import com.learn.redisson.module.mapper.UserMapper;
import com.learn.redisson.server.IRedissonTopicObjService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 分布式对象内容的service
 */
@Service("redissonTopicObjService")
@Slf4j
public class RedissonTopicObjServiceImpl implements IRedissonTopicObjService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedissonClient redissonClient;

    public void sendTopicEmail(final Integer userId){
        User user = userMapper.selectByPrimaryKey(userId);
        if(null!=user && StringUtils.isNotBlank(user.getEmail())){
            log.info("userId:{} 的邮箱信息被投递到topic中",userId);
            //将待发送的目标邮箱，放入到topic中，消费者读取该邮件，然后发送邮件
            RTopic<Object> toSendEMailAddress = redissonClient.getTopic(RedisKeyConstant.REDISSON_TOPIC_EMAIL_KEY);
            toSendEMailAddress.publish(user.getEmail());
        }
    }

}
