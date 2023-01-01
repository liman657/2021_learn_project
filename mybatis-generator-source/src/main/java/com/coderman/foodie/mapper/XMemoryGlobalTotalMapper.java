package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XMemoryGlobalTotal;
import java.util.List;

public interface XMemoryGlobalTotalMapper {
    int insert(XMemoryGlobalTotal record);

    List<XMemoryGlobalTotal> selectAll();
}