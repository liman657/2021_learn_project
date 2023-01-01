package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.UserSummaryByStages;
import java.util.List;

public interface UserSummaryByStagesMapper {
    int insert(UserSummaryByStages record);

    List<UserSummaryByStages> selectAll();
}