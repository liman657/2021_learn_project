package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XUserSummaryByStatementType;
import java.util.List;

public interface XUserSummaryByStatementTypeMapper {
    int insert(XUserSummaryByStatementType record);

    List<XUserSummaryByStatementType> selectAll();
}