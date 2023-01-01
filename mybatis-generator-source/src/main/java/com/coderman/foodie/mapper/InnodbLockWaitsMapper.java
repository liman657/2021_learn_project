package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbLockWaits;
import java.util.List;

public interface InnodbLockWaitsMapper {
    int insert(InnodbLockWaits record);

    List<InnodbLockWaits> selectAll();
}