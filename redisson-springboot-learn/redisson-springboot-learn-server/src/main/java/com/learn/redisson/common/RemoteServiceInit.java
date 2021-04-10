package com.learn.redisson.common;

import com.learn.redisson.api.service.IRemoteProductService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RRemoteService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * autor:liman
 * createtime:2021/4/10
 * comment: redisson服务注册
 */
@Component
@Slf4j
public class RemoteServiceInit implements CommandLineRunner {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private IRemoteProductService iRemoteProductService;

    @Override
    public void run(String... args) throws Exception {
        log.info("-----项目启动，开始发布对应服务------");
        RRemoteService remoteService = redissonClient.getRemoteService();
        //注册服务的时候，设置线程个数
        remoteService.register(IRemoteProductService.class, iRemoteProductService, 12);

        /*RRemoteService remoteService = redisson.getRemoteService();
        SomeServiceImpl someServiceImpl = new SomeServiceImpl();

        //在调用远程方法以前，应该首先注册远程服务
        //只注册了一个服务端工作者实例，只能同时执行一个并发调用
        remoteService.register(SomeServiceInterface.class, someServiceImpl);

        //注册了12个服务端工作者实例，可以同时执行12个并发调用
        remoteService.register(SomeServiceInterface.class, someServiceImpl, 12);*/
    }
}
