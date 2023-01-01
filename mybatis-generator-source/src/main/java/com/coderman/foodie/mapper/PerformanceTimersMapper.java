package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.PerformanceTimers;
import java.util.List;

public interface PerformanceTimersMapper {
    int insert(PerformanceTimers record);

    List<PerformanceTimers> selectAll();
}