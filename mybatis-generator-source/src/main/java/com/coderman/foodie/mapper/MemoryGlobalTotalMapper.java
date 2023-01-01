package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemoryGlobalTotal;
import java.util.List;

public interface MemoryGlobalTotalMapper {
    int insert(MemoryGlobalTotal record);

    List<MemoryGlobalTotal> selectAll();
}