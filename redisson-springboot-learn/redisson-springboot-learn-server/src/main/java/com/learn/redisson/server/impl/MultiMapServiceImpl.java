package com.learn.redisson.server.impl;

import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.SysConfig;
import com.learn.redisson.module.mapper.SysConfigMapper;
import com.learn.redisson.server.IMultiMapService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RSetMultimap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * autor:liman
 * createtime:2021/4/3
 * comment:multiMapService 实例
 */
@Service("multiMapService")
@Slf4j
public class MultiMapServiceImpl implements IMultiMapService {

    @Autowired
    private SysConfigMapper sysConfigMapper;
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 录入数据字典
     *
     * @param sysConfig
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int insertConfigData(SysConfig sysConfig) {
        int res = sysConfigMapper.insertSelective(sysConfig);
        if (0 < res) {
            RSetMultimap<String, SysConfig> setMultimap = redissonClient.getSetMultimap(RedisKeyConstant.REDISSON_MULIT_MAP_KEY);
            List<SysConfig> sysConfigList = sysConfigMapper.selectByType(sysConfig.getType());
            setMultimap.putAll(sysConfig.getType(), sysConfigList);

            return sysConfig.getId();
        }
        return -1;
    }

    /**
     * 获取数据字典
     *
     * @param typeCode
     * @return
     */
    public Collection<SysConfig> getConfigTypeList(final String typeCode) {
        RSetMultimap<String, SysConfig> setMultimap = redissonClient.getSetMultimap(RedisKeyConstant.REDISSON_MULIT_MAP_KEY);
        return setMultimap.get(typeCode);
    }

    /**
     * 删除数据字典，其中实际包含了修改的部分
     *
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteConfig(final Integer id) {
        SysConfig entityConfig = sysConfigMapper.selectByPrimaryKey(id);
        if (null != entityConfig) {
            int res = sysConfigMapper.deleteConfig(id);
            if (0 < res) {
                //先查出数据库中当前这个大类对应的小类，然后直接删除缓存中的旧版本数据，之后再替换成数据库库中最新的值
                RSetMultimap<String, SysConfig> setMultimap = redissonClient.getSetMultimap(RedisKeyConstant.REDISSON_MULIT_MAP_KEY);
                List<SysConfig> newTypeDataList = sysConfigMapper.selectByType(entityConfig.getType());
                setMultimap.fastRemove(entityConfig.getType());//删除缓存中旧版本的值

                if (null != newTypeDataList && !newTypeDataList.isEmpty()) {
                    setMultimap.putAll(entityConfig.getType(), newTypeDataList);
                }
                return 1;
            }
        }
        return -1;
    }

}
