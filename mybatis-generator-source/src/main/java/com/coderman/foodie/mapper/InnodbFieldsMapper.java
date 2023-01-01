package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbFields;
import java.util.List;

public interface InnodbFieldsMapper {
    int insert(InnodbFields record);

    List<InnodbFields> selectAll();
}