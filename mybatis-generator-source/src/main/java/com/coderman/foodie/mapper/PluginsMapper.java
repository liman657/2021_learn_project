package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Plugins;
import java.util.List;

public interface PluginsMapper {
    int insert(Plugins record);

    List<Plugins> selectAll();
}