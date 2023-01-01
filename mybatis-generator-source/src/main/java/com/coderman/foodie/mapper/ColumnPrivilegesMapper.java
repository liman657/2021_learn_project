package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ColumnPrivileges;
import java.util.List;

public interface ColumnPrivilegesMapper {
    int insert(ColumnPrivileges record);

    List<ColumnPrivileges> selectAll();
}