package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.CharacterSets;
import java.util.List;

public interface CharacterSetsMapper {
    int insert(CharacterSets record);

    List<CharacterSets> selectAll();
}