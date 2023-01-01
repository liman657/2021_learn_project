package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XHostSummaryByStages;
import java.util.List;

public interface XHostSummaryByStagesMapper {
    int insert(XHostSummaryByStages record);

    List<XHostSummaryByStages> selectAll();
}