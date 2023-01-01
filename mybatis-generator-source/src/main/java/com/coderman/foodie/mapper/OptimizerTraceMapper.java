package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.OptimizerTrace;
import java.util.List;

public interface OptimizerTraceMapper {
    int insert(OptimizerTrace record);

    List<OptimizerTrace> selectAll();
}