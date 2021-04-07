package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.Notice;
import com.learn.redisson.module.mapper.NoticeMapper;
import com.learn.redisson.server.IQueueService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * autor:liman
 * createtime:2021/4/7
 * comment: 队列的service实例
 */
@Service("queueService")
@Slf4j
public class QueueServiceImpl implements IQueueService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 创建公告
     * @param notice
     * @return
     */
    public int createNotice(Notice notice) {
        int res = noticeMapper.insertSelective(notice);
        if (0 < res) {
            //非阻塞式队列，普通队列
//            RQueue<Notice> queue = redissonClient.getQueue(RedisKeyConstant.REDISSON_QUEUE_REDIS_KEY);
//            queue.offer(notice);
            //阻塞式队列
            RBlockingQueue<Notice> blockingQueue=redissonClient.getBlockingQueue(RedisKeyConstant.REDISSON_QUEUE_REDIS_KEY);
            blockingQueue.offer(notice);
            return 1;
        }
        return -1;
    }

}
