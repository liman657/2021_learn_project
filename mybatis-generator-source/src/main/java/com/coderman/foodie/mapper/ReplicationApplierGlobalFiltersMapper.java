package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationApplierGlobalFilters;
import java.util.List;

public interface ReplicationApplierGlobalFiltersMapper {
    int insert(ReplicationApplierGlobalFilters record);

    List<ReplicationApplierGlobalFilters> selectAll();
}