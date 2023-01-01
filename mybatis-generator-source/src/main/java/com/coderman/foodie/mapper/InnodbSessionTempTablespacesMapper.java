package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbSessionTempTablespaces;
import java.util.List;

public interface InnodbSessionTempTablespacesMapper {
    int insert(InnodbSessionTempTablespaces record);

    List<InnodbSessionTempTablespaces> selectAll();
}