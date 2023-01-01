package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Language;
import java.util.List;

public interface LanguageMapper {
    int deleteByPrimaryKey(Byte languageId);

    int insert(Language record);

    Language selectByPrimaryKey(Byte languageId);

    List<Language> selectAll();

    int updateByPrimaryKey(Language record);
}