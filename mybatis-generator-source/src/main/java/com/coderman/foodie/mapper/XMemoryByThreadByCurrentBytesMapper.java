package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XMemoryByThreadByCurrentBytes;
import java.util.List;

public interface XMemoryByThreadByCurrentBytesMapper {
    int insert(XMemoryByThreadByCurrentBytes record);

    List<XMemoryByThreadByCurrentBytes> selectAll();
}