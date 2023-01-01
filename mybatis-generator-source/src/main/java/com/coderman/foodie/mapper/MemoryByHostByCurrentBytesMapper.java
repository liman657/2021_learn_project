package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemoryByHostByCurrentBytes;
import java.util.List;

public interface MemoryByHostByCurrentBytesMapper {
    int insert(MemoryByHostByCurrentBytes record);

    List<MemoryByHostByCurrentBytes> selectAll();
}