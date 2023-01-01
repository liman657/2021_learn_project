package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserSummaryByStatementLatency;
import java.util.List;

public interface UserSummaryByStatementLatencyMapper {
    int insert(UserSummaryByStatementLatency record);

    List<UserSummaryByStatementLatency> selectAll();
}