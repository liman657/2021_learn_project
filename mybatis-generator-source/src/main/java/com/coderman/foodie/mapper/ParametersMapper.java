package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Parameters;
import java.util.List;

public interface ParametersMapper {
    int insert(Parameters record);

    List<Parameters> selectAll();
}