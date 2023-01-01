package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XUserSummary;
import java.util.List;

public interface XUserSummaryMapper {
    int insert(XUserSummary record);

    List<XUserSummary> selectAll();
}