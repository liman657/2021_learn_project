package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HostSummaryByStatementType;
import java.util.List;

public interface HostSummaryByStatementTypeMapper {
    int insert(HostSummaryByStatementType record);

    List<HostSummaryByStatementType> selectAll();
}