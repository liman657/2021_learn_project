package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ActorInfo;
import java.util.List;

public interface ActorInfoMapper {
    int insert(ActorInfo record);

    List<ActorInfo> selectAll();
}