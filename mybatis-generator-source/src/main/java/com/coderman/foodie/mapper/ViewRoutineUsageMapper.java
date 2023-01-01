package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ViewRoutineUsage;
import java.util.List;

public interface ViewRoutineUsageMapper {
    int insert(ViewRoutineUsage record);

    List<ViewRoutineUsage> selectAll();
}