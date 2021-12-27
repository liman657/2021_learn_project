package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.Collect;

import java.util.List;

public interface CollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    Collect selectByPrimaryKey(Integer id);

    List<Collect> selectAll();

    int updateByPrimaryKey(Collect record);
}