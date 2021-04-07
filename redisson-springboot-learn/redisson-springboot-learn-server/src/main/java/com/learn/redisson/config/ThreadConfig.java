package com.learn.redisson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * autor:liman
 * createtime:2021/4/7
 * comment:
 */
@Configuration
public class ThreadConfig {

    /**
     * 线程池的配置
     * @return
     */
    @Bean("threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);//核心线程数
        executor.setMaxPoolSize(8);//最大线程数
        executor.setKeepAliveSeconds(10);//最大活动线程数
        executor.setQueueCapacity(8);//等待队列容量
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        return executor;
    }

}
