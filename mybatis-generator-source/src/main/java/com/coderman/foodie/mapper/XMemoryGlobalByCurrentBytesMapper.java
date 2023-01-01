package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XMemoryGlobalByCurrentBytes;
import java.util.List;

public interface XMemoryGlobalByCurrentBytesMapper {
    int insert(XMemoryGlobalByCurrentBytes record);

    List<XMemoryGlobalByCurrentBytes> selectAll();
}