package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.EnabledRoles;
import java.util.List;

public interface EnabledRolesMapper {
    int insert(EnabledRoles record);

    List<EnabledRoles> selectAll();
}