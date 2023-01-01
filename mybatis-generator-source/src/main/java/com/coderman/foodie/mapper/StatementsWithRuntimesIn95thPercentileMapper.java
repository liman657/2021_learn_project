package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatementsWithRuntimesIn95thPercentile;
import java.util.List;

public interface StatementsWithRuntimesIn95thPercentileMapper {
    int insert(StatementsWithRuntimesIn95thPercentile record);

    List<StatementsWithRuntimesIn95thPercentile> selectAll();
}