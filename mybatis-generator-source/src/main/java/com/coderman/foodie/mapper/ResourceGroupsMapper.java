package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ResourceGroups;
import java.util.List;

public interface ResourceGroupsMapper {
    int insert(ResourceGroups record);

    List<ResourceGroups> selectAll();
}