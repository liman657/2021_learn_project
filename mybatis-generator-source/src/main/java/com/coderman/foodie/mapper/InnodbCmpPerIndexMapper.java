package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbCmpPerIndex;
import java.util.List;

public interface InnodbCmpPerIndexMapper {
    int insert(InnodbCmpPerIndex record);

    List<InnodbCmpPerIndex> selectAll();
}