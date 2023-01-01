package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XMemoryByHostByCurrentBytes;
import java.util.List;

public interface XMemoryByHostByCurrentBytesMapper {
    int insert(XMemoryByHostByCurrentBytes record);

    List<XMemoryByHostByCurrentBytes> selectAll();
}