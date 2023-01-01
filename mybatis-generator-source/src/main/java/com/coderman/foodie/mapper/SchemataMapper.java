package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Schemata;
import java.util.List;

public interface SchemataMapper {
    int insert(Schemata record);

    List<Schemata> selectAll();
}