package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SchemaPrivileges;
import java.util.List;

public interface SchemaPrivilegesMapper {
    int insert(SchemaPrivileges record);

    List<SchemaPrivileges> selectAll();
}