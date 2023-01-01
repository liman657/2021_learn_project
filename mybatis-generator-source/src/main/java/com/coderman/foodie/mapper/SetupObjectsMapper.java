package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SetupObjects;
import java.util.List;

public interface SetupObjectsMapper {
    int insert(SetupObjects record);

    List<SetupObjects> selectAll();
}