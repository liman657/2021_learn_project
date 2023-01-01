package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HostCache;
import java.util.List;

public interface HostCacheMapper {
    int deleteByPrimaryKey(String ip);

    int insert(HostCache record);

    HostCache selectByPrimaryKey(String ip);

    List<HostCache> selectAll();

    int updateByPrimaryKey(HostCache record);
}