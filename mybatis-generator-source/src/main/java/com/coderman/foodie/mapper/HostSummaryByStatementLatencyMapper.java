package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HostSummaryByStatementLatency;
import java.util.List;

public interface HostSummaryByStatementLatencyMapper {
    int insert(HostSummaryByStatementLatency record);

    List<HostSummaryByStatementLatency> selectAll();
}