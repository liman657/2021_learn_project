package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Tables;
import java.util.List;

public interface TablesMapper {
    int insert(Tables record);

    List<Tables> selectAll();
}