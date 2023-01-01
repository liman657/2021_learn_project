package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcSubsection;
import java.util.List;

public interface ImcSubsectionMapper {
    int deleteByPrimaryKey(Integer subId);

    int insert(ImcSubsection record);

    ImcSubsection selectByPrimaryKey(Integer subId);

    List<ImcSubsection> selectAll();

    int updateByPrimaryKey(ImcSubsection record);
}