package com.learn.redisson.server.impl;

import com.google.common.collect.Lists;
import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.Item;
import com.learn.redisson.module.mapper.ItemMapper;
import com.learn.redisson.server.IDataService;
import com.sun.mail.imap.protocol.ID;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * autor:liman
 * createtime:2021/3/24
 * comment:
 */
@Service("dataService")
@Slf4j
public class DataServiceImpl implements IDataService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private RedissonClient redissonClient;

    public void insertBatch(Set<String> set) {
        List<Item> itemList = Lists.newLinkedList();
        if (null != set && !set.isEmpty()) {
            set.forEach(value -> {
                Item dataItem = new Item(null, value, value);
                itemList.add(dataItem);
            });
            log.info("开始插入数据");
            //批量插入到数据库中
            int res = itemMapper.insertBatch(itemList);

            //将插入的数据，放入布隆过滤器中
            if (0 < res) {
                RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter(RedisKeyConstant.REDISSON_BLOOM_ITEM_KEY);
                bloomFilter.tryInit(1000000L, 0.001);
                set.forEach(s -> bloomFilter.add(s));
            }
            log.info("线程数据插入完成");

        }
    }

}
