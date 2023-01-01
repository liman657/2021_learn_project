package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ReferentialConstraints;
import java.util.List;

public interface ReferentialConstraintsMapper {
    int insert(ReferentialConstraints record);

    List<ReferentialConstraints> selectAll();
}