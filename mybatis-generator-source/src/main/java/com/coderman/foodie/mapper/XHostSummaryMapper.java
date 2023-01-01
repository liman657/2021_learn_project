package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XHostSummary;
import java.util.List;

public interface XHostSummaryMapper {
    int insert(XHostSummary record);

    List<XHostSummary> selectAll();
}