package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.server.IRateLimiterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.Environment;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * autor:liman
 * createtime:2021/3/24
 * comment:
 */
@Service("rateLimiterService")
@Slf4j
public class RateLimiterServiceImpl implements IRateLimiterService {

    @Autowired
    private RedissonClient redissonClient;
//    @Autowired
//    private Environment environment;

    public void sendMsg(final String phoneNo) {
        if (StringUtils.isNotBlank(phoneNo)) {
            RRateLimiter rateLimiter = redissonClient.getRateLimiter(RedisKeyConstant.REDISSON_RATE_LIMITER_KEY + phoneNo);
            //初始化  最大流速 = 每 xx 秒钟产生1个令牌(同个手机号 xx 秒内只能发一次) ~ 每10秒钟产生1个令牌 -
            //真实应用中还得借助缓存/数据库记录发送的次数、ip限制、白名单、黑名单限制等
            rateLimiter.trySetRate(RateType.OVERALL, 1, 10, RateIntervalUnit.SECONDS);
            if (rateLimiter.tryAcquire(1)) {
                log.info("----发送短信，手机号：{}", phoneNo);

            } else {
                log.warn("操作过于频繁，请稍后再试");
            }
        }

    }

}
