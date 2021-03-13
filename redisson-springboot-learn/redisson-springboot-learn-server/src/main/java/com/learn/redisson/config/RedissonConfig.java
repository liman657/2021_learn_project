package com.learn.redisson.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment:
 */
@Configuration
@Slf4j
public class RedissonConfig {
    @Autowired
    private Environment environment;

    /**
     * 连接单实例的Redis服务器的 RedissonClient
     * @return
     */
    @Bean
    public RedissonClient redissonClient(){
        Config redissonConfig = new Config();
        redissonConfig.useSingleServer().setAddress(environment.getProperty("redisson.url.single"));
        RedissonClient redissonClient = Redisson.create(redissonConfig);
        log.info("redisson client 单节点模式创建成功");
        return redissonClient;
    }

//    /**
//     * 连接Redis集群的 RedissonClient
//     * @return
//     */
//    @Bean
//    public RedissonClient redissonClientCluster(){
//        Config redissonConfig = new Config();
//        redissonConfig.useClusterServers().setScanInterval(3000)
//                .addNodeAddress(environment.getProperty("redisson.url.cluster").split(","))
//                //各种池大小，如何设置可以参考redisson官网
//                .setMasterConnectionMinimumIdleSize(10)
//                .setMasterConnectionPoolSize(64)
//                .setMasterConnectionMinimumIdleSize(10)
//                .setMasterConnectionPoolSize(64)
//                .setConnectTimeout(15000);
//
//        RedissonClient redissonClusterClient = Redisson.create(redissonConfig);
//        return redissonClusterClient;
//    }

}
