package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Tablespaces;
import java.util.List;

public interface TablespacesMapper {
    int insert(Tablespaces record);

    List<Tablespaces> selectAll();
}