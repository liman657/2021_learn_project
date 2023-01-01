package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbForeign;
import java.util.List;

public interface InnodbForeignMapper {
    int insert(InnodbForeign record);

    List<InnodbForeign> selectAll();
}