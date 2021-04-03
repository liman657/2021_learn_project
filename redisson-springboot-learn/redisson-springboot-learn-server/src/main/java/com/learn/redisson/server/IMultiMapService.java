package com.learn.redisson.server;

import com.learn.redisson.module.entity.SysConfig;

import java.util.Collection;

/**
 * autor:liman
 * createtime:2021/4/3
 * comment:
 */
public interface IMultiMapService {

    public int insertConfigData(SysConfig sysConfig);

    public Collection<SysConfig> getConfigTypeList(final String typeCode);

    public int deleteConfig(final Integer id);
}
