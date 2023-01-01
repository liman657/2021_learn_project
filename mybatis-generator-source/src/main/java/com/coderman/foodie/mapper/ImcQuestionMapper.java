package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ImcQuestion;
import java.util.List;

public interface ImcQuestionMapper {
    int deleteByPrimaryKey(Integer questId);

    int insert(ImcQuestion record);

    ImcQuestion selectByPrimaryKey(Integer questId);

    List<ImcQuestion> selectAll();

    int updateByPrimaryKey(ImcQuestion record);
}