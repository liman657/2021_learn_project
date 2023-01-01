package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.XInnodbLockWaits;
import java.util.List;

public interface XInnodbLockWaitsMapper {
    int insert(XInnodbLockWaits record);

    List<XInnodbLockWaits> selectAll();
}