package com.learn.redisson.server;

import com.learn.redisson.module.entity.MailInfo;

/**
 * autor:liman
 * createtime:2021/3/30
 * comment: mapCache服务接口
 */
public interface IMapCacheService {

    public void createMail(MailInfo info) throws Exception;

    public void invalidateEmail(final Integer id) throws Exception;

}
