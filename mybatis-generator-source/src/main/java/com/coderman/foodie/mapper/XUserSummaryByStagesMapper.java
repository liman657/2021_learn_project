package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XUserSummaryByStages;
import java.util.List;

public interface XUserSummaryByStagesMapper {
    int insert(XUserSummaryByStages record);

    List<XUserSummaryByStages> selectAll();
}