package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Praise;
import java.util.List;

public interface PraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Praise record);

    Praise selectByPrimaryKey(Integer id);

    List<Praise> selectAll();

    int updateByPrimaryKey(Praise record);
}