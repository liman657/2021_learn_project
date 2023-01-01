package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XStatementAnalysis;
import java.util.List;

public interface XStatementAnalysisMapper {
    int insert(XStatementAnalysis record);

    List<XStatementAnalysis> selectAll();
}