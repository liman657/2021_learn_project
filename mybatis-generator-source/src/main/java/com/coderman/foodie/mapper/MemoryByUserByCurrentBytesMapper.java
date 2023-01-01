package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemoryByUserByCurrentBytes;
import java.util.List;

public interface MemoryByUserByCurrentBytesMapper {
    int insert(MemoryByUserByCurrentBytes record);

    List<MemoryByUserByCurrentBytes> selectAll();
}