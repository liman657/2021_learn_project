package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.KeyColumnUsage;
import java.util.List;

public interface KeyColumnUsageMapper {
    int insert(KeyColumnUsage record);

    List<KeyColumnUsage> selectAll();
}