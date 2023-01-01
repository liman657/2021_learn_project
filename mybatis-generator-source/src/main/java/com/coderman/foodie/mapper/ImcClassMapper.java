package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcClass;
import java.util.List;

public interface ImcClassMapper {
    int deleteByPrimaryKey(Short classId);

    int insert(ImcClass record);

    ImcClass selectByPrimaryKey(Short classId);

    List<ImcClass> selectAll();

    int updateByPrimaryKey(ImcClass record);
}