package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.TablePrivileges;
import java.util.List;

public interface TablePrivilegesMapper {
    int insert(TablePrivileges record);

    List<TablePrivileges> selectAll();
}