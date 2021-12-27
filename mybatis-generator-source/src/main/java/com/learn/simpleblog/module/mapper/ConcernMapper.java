package com.learn.simpleblog.module.mapper;

import com.learn.simpleblog.module.domain.Concern;
import java.util.List;

public interface ConcernMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Concern record);

    Concern selectByPrimaryKey(Integer id);

    List<Concern> selectAll();

    int updateByPrimaryKey(Concern record);
}