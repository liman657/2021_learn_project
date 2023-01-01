package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaTableLockWaits;
import java.util.List;

public interface SchemaTableLockWaitsMapper {
    int insert(SchemaTableLockWaits record);

    List<SchemaTableLockWaits> selectAll();
}