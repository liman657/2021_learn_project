package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcType;
import java.util.List;

public interface ImcTypeMapper {
    int deleteByPrimaryKey(Short typeId);

    int insert(ImcType record);

    ImcType selectByPrimaryKey(Short typeId);

    List<ImcType> selectAll();

    int updateByPrimaryKey(ImcType record);
}