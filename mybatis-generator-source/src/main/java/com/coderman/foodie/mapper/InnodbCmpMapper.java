package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbCmp;
import java.util.List;

public interface InnodbCmpMapper {
    int insert(InnodbCmp record);

    List<InnodbCmp> selectAll();
}