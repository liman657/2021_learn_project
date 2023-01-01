package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Engines;
import java.util.List;

public interface EnginesMapper {
    int insert(Engines record);

    List<Engines> selectAll();
}