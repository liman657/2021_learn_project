package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbTables;
import java.util.List;

public interface InnodbTablesMapper {
    int insert(InnodbTables record);

    List<InnodbTables> selectAll();
}