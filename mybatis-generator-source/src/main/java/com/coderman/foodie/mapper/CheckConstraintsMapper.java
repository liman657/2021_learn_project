package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.CheckConstraints;
import java.util.List;

public interface CheckConstraintsMapper {
    int insert(CheckConstraints record);

    List<CheckConstraints> selectAll();
}