package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XUserSummaryByStatementLatency;
import java.util.List;

public interface XUserSummaryByStatementLatencyMapper {
    int insert(XUserSummaryByStatementLatency record);

    List<XUserSummaryByStatementLatency> selectAll();
}