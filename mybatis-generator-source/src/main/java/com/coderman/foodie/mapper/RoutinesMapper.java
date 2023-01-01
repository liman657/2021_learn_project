package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Routines;
import java.util.List;

public interface RoutinesMapper {
    int insert(Routines record);

    List<Routines> selectAll();
}