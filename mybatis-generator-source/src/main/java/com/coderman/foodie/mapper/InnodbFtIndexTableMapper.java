package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbFtIndexTable;
import java.util.List;

public interface InnodbFtIndexTableMapper {
    int insert(InnodbFtIndexTable record);

    List<InnodbFtIndexTable> selectAll();
}