package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Plugin;
import java.util.List;

public interface PluginMapper {
    int deleteByPrimaryKey(String name);

    int insert(Plugin record);

    Plugin selectByPrimaryKey(String name);

    List<Plugin> selectAll();

    int updateByPrimaryKey(Plugin record);
}