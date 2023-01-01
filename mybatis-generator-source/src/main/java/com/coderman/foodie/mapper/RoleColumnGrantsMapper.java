package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.RoleColumnGrants;
import java.util.List;

public interface RoleColumnGrantsMapper {
    int insert(RoleColumnGrants record);

    List<RoleColumnGrants> selectAll();
}