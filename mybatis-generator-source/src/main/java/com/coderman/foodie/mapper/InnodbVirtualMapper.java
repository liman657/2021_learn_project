package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbVirtual;
import java.util.List;

public interface InnodbVirtualMapper {
    int insert(InnodbVirtual record);

    List<InnodbVirtual> selectAll();
}