package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.VariablesInfo;
import java.util.List;

public interface VariablesInfoMapper {
    int insert(VariablesInfo record);

    List<VariablesInfo> selectAll();
}