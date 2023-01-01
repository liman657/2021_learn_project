package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XHostSummaryByStatementLatency;
import java.util.List;

public interface XHostSummaryByStatementLatencyMapper {
    int insert(XHostSummaryByStatementLatency record);

    List<XHostSummaryByStatementLatency> selectAll();
}