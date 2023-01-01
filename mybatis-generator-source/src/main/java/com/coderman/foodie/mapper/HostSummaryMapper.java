package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HostSummary;
import java.util.List;

public interface HostSummaryMapper {
    int insert(HostSummary record);

    List<HostSummary> selectAll();
}