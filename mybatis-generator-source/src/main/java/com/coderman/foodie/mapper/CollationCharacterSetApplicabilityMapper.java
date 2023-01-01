package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.CollationCharacterSetApplicability;
import java.util.List;

public interface CollationCharacterSetApplicabilityMapper {
    int insert(CollationCharacterSetApplicability record);

    List<CollationCharacterSetApplicability> selectAll();
}