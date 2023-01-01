package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Profiling;
import java.util.List;

public interface ProfilingMapper {
    int insert(Profiling record);

    List<Profiling> selectAll();
}