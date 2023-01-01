package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XMemoryByUserByCurrentBytes;
import java.util.List;

public interface XMemoryByUserByCurrentBytesMapper {
    int insert(XMemoryByUserByCurrentBytes record);

    List<XMemoryByUserByCurrentBytes> selectAll();
}