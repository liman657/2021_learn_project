package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MemoryByThreadByCurrentBytes;
import java.util.List;

public interface MemoryByThreadByCurrentBytesMapper {
    int insert(MemoryByThreadByCurrentBytes record);

    List<MemoryByThreadByCurrentBytes> selectAll();
}