package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ApplicableRoles;
import java.util.List;

public interface ApplicableRolesMapper {
    int insert(ApplicableRoles record);

    List<ApplicableRoles> selectAll();
}