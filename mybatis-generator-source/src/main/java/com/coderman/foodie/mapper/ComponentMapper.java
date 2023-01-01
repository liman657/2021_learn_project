package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Component;
import java.util.List;

public interface ComponentMapper {
    int deleteByPrimaryKey(Integer componentId);

    int insert(Component record);

    Component selectByPrimaryKey(Integer componentId);

    List<Component> selectAll();

    int updateByPrimaryKey(Component record);
}