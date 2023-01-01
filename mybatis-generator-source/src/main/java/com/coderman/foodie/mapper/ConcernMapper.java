package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Concern;
import java.util.List;

public interface ConcernMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Concern record);

    Concern selectByPrimaryKey(Integer id);

    List<Concern> selectAll();

    int updateByPrimaryKey(Concern record);
}