package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Processlist;
import java.util.List;

public interface ProcesslistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Processlist record);

    Processlist selectByPrimaryKey(Long id);

    List<Processlist> selectAll();

    int updateByPrimaryKey(Processlist record);
}