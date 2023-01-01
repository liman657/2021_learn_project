package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.RoleTableGrants;
import java.util.List;

public interface RoleTableGrantsMapper {
    int insert(RoleTableGrants record);

    List<RoleTableGrants> selectAll();
}