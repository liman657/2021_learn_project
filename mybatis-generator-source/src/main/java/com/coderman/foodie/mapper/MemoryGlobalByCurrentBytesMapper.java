package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemoryGlobalByCurrentBytes;
import java.util.List;

public interface MemoryGlobalByCurrentBytesMapper {
    int insert(MemoryGlobalByCurrentBytes record);

    List<MemoryGlobalByCurrentBytes> selectAll();
}