package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HostSummaryByStages;
import java.util.List;

public interface HostSummaryByStagesMapper {
    int insert(HostSummaryByStages record);

    List<HostSummaryByStages> selectAll();
}