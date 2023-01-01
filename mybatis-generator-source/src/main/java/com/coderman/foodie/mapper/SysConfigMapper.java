package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SysConfig;
import java.util.List;

public interface SysConfigMapper {
    int insert(SysConfig record);

    List<SysConfig> selectAll();
}