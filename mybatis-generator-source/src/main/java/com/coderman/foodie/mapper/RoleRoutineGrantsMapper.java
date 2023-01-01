package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.RoleRoutineGrants;
import java.util.List;

public interface RoleRoutineGrantsMapper {
    int insert(RoleRoutineGrants record);

    List<RoleRoutineGrants> selectAll();
}