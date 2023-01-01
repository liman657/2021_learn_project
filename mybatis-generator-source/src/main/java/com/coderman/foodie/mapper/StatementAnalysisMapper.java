package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StatementAnalysis;
import java.util.List;

public interface StatementAnalysisMapper {
    int insert(StatementAnalysis record);

    List<StatementAnalysis> selectAll();
}