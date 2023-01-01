package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ObjectsSummaryGlobalByType;
import java.util.List;

public interface ObjectsSummaryGlobalByTypeMapper {
    int insert(ObjectsSummaryGlobalByType record);

    List<ObjectsSummaryGlobalByType> selectAll();
}