package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XHostSummaryByStatementType;
import java.util.List;

public interface XHostSummaryByStatementTypeMapper {
    int insert(XHostSummaryByStatementType record);

    List<XHostSummaryByStatementType> selectAll();
}