package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.MailInfo;
import com.learn.redisson.module.mapper.MailInfoMapper;
import com.learn.redisson.server.IMapCacheService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * autor:liman
 * createtime:2021/3/30
 * comment:
 */
@Service("mapCacheService")
@Slf4j
public class MapCacheServiceImpl implements IMapCacheService {
    @Autowired
    private MailInfoMapper mailInfoMapper;
    @Autowired
    private MailServiceImpl mailService;
    @Autowired
    private RedissonClient redissonClient;

    //创建一封邮件(当is_delay=1时，意味着发送的时间将大于当前时间 - 这个可以由前端控制)
    public void createMail(MailInfo info) throws Exception {
        //TODO:计算出当前这封邮件的待发送的时间 与 当前这一时刻的时间 的距离 = ttl : 限当天，定时发送的时间 12:00，当前的时刻：11:00 意味着
        //TODO:邮件即将在1个小时后发送，ttl=1h
        long diffTime = 0;
        String sendDateTime = info.getSendDateTime();
        if (info.getIsDelay().intValue() == 1 && StringUtils.isNotBlank(sendDateTime)) {
            Date sendTimeDate = RedisKeyConstant.DATE_TIME_FORMAT.parse(info.getSendDateTime());
            info.setSendTime(sendTimeDate);//获取邮件中的发送时间

            //计算剩余时间
            diffTime = sendTimeDate.getTime() - System.currentTimeMillis();
            if (diffTime < 0) {
                throw new RuntimeException("邮件待发送时间不得早于当前时间");
            }
        }

        //开始发送邮件
        int res = mailInfoMapper.insertSelective(info);
        if (res > 0) {
            if (diffTime > 0) {//延时发送
                RMapCache<Integer, String> mapCache = redissonClient.getMapCache(RedisKeyConstant.REDISSON_MAP_CACHE_MAIL_KEY);
                mapCache.put(info.getId(), info.getTos(), diffTime, TimeUnit.MILLISECONDS);
                //TODO:这里使用日志代替发送邮件
                log.info("准备发送的邮件信息为:{}", info.toString());
            } else {//即时发送
                mailService.sendSimpleEmail(info.getSubject(), info.getContent(), info.getTos());
            }
        }

    }


    /**
     * 失效待发送的邮件 ~ 可能是某种原因不想发送出去了 ~ 针对isDelay=1的，即需要延时发送的那些邮件
     *
     * @param id
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void invalidateEmail(final Integer id) throws Exception {
        MailInfo entity = mailInfoMapper.selectByPrimaryKey(id);
        if (entity == null || entity.getIsActive().intValue() == 0 || entity.getIsDelay().intValue() == 0) {
            throw new RuntimeException("待失效的邮件记录不合法或者不存在！");
        }

        //TODO:更新DB
        int res = mailInfoMapper.invalidateMail(id);
        if (res > 0) {
            //TODO:同时去缓存里头移除掉mapCache对应的key
            RMapCache<Integer, String> rMapCache = redissonClient.getMapCache(RedisKeyConstant.REDISSON_MAP_CACHE_MAIL_KEY);
            rMapCache.fastRemove(id);//这里是直接删除了待发送的存储与MapCache中的key,remove不止有这一种方法
        }
    }

}
