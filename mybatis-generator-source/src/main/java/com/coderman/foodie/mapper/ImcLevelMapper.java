package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcLevel;
import java.util.List;

public interface ImcLevelMapper {
    int deleteByPrimaryKey(Short levelId);

    int insert(ImcLevel record);

    ImcLevel selectByPrimaryKey(Short levelId);

    List<ImcLevel> selectAll();

    int updateByPrimaryKey(ImcLevel record);
}