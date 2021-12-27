package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.Praise;

import java.util.List;

public interface PraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Praise record);

    Praise selectByPrimaryKey(Integer id);

    List<Praise> selectAll();

    int updateByPrimaryKey(Praise record);
}