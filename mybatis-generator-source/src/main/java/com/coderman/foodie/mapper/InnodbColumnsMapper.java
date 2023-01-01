package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbColumns;
import java.util.List;

public interface InnodbColumnsMapper {
    int insert(InnodbColumns record);

    List<InnodbColumns> selectAll();
}