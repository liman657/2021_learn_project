package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReplicationApplierFilters;
import java.util.List;

public interface ReplicationApplierFiltersMapper {
    int insert(ReplicationApplierFilters record);

    List<ReplicationApplierFilters> selectAll();
}