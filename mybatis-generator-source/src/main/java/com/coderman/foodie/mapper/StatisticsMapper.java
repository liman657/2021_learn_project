package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Statistics;
import java.util.List;

public interface StatisticsMapper {
    int insert(Statistics record);

    List<Statistics> selectAll();
}