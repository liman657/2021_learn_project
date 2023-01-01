package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.HelpKeyword;
import java.util.List;

public interface HelpKeywordMapper {
    int deleteByPrimaryKey(Integer helpKeywordId);

    int insert(HelpKeyword record);

    HelpKeyword selectByPrimaryKey(Integer helpKeywordId);

    List<HelpKeyword> selectAll();

    int updateByPrimaryKey(HelpKeyword record);
}