package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HelpRelation;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HelpRelationMapper {
    int deleteByPrimaryKey(@Param("helpKeywordId") Integer helpKeywordId, @Param("helpTopicId") Integer helpTopicId);

    int insert(HelpRelation record);

    List<HelpRelation> selectAll();
}