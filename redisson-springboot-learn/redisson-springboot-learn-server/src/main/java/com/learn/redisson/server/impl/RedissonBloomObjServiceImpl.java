package com.learn.redisson.server.impl;

import com.google.common.collect.Lists;
import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.Item;
import com.learn.redisson.module.mapper.ItemMapper;
import com.learn.redisson.server.IDataService;
import com.learn.redisson.server.IRedissonBloomObjService;
import com.learn.redisson.thread.InsertBigDataThread;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.apache.ibatis.annotations.Insert;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * autor:liman
 * createtime:2021/3/22
 * comment:
 */
@Service("redissonBloomObjService")
@Slf4j
public class RedissonBloomObjServiceImpl implements IRedissonBloomObjService {
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private IDataService dataService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addItem(Item item) {
        Integer id = -1;
        //通过bloom过滤器，判断待添加的商品是否存在
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter(RedisKeyConstant.REDISSON_BLOOM_ITEM_KEY);
        bloomFilter.tryInit(10000000L, 0.03);
        if (bloomFilter.contains(item.getCode())) {
            throw new RuntimeException("该商品编号已经存在");
        }
        //插入数据库
        item.setCreateTime(new Date());
        int res = itemMapper.insertSelective(item);
        if (res > 0) {
            id = item.getId();
            //将商品编号加入到bloom过滤器中
            bloomFilter.add(item.getCode());
        }
        return id;
    }

    /**
     * 通过多线程，生成大量数据，插入数据库
     */
    public void genDataByThread() throws Exception {
        //利用JUC的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<InsertBigDataThread> threadList = Lists.newLinkedList();
        for (int i = 0; i < 10; i++) {
            threadList.add(new InsertBigDataThread(dataService));
        }
        executorService.invokeAll(threadList);
    }

    public boolean isInBigData(final String itemCode) {
        RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter(RedisKeyConstant.REDISSON_BLOOM_ITEM_KEY);
//        bloomFilter.tryInit(1000000L, 0.001);
        boolean isExist = bloomFilter.contains(itemCode);
        log.info("判断是否存在于bloomFilter中的结果为:{}", isExist);
        return isExist;
    }
}
