package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XSchemaTableLockWaits;
import java.util.List;

public interface XSchemaTableLockWaitsMapper {
    int insert(XSchemaTableLockWaits record);

    List<XSchemaTableLockWaits> selectAll();
}