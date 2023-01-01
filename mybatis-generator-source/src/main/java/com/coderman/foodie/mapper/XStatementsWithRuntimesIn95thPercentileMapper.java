package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XStatementsWithRuntimesIn95thPercentile;
import java.util.List;

public interface XStatementsWithRuntimesIn95thPercentileMapper {
    int insert(XStatementsWithRuntimesIn95thPercentile record);

    List<XStatementsWithRuntimesIn95thPercentile> selectAll();
}