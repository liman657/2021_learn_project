package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.DataLockWaits;
import java.util.List;

public interface DataLockWaitsMapper {
    int insert(DataLockWaits record);

    List<DataLockWaits> selectAll();
}