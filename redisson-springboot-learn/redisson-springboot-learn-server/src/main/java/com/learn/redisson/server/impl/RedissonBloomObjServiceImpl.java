package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.Item;
import com.learn.redisson.module.mapper.ItemMapper;
import com.learn.redisson.server.IRedissonBloomObjService;
import net.bytebuddy.asm.Advice;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * autor:liman
 * createtime:2021/3/22
 * comment:
 */
@Service("redissonBloomObjService")
public class RedissonBloomObjServiceImpl implements IRedissonBloomObjService {
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private ItemMapper itemMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer addItem(Item item) {
        Integer id = -1;
        //通过bloom过滤器，判断待添加的商品是否存在
        RBloomFilter<Object> bloomFilter = redissonClient.getBloomFilter(RedisKeyConstant.REDISSON_BLOOM_ITEM_KEY);
        bloomFilter.tryInit(10000000L,0.03);
        if(bloomFilter.contains(item.getCode())){
            throw new RuntimeException("该商品编号已经存在");
        }
        //插入数据库
        item.setCreateTime(new Date());
        int res = itemMapper.insertSelective(item);
        if(res>0){
            id = item.getId();
            //将商品编号加入到bloom过滤器中
            bloomFilter.add(item.getCode());
        }
        return id;
    }
}
