package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Actor;
import java.util.List;

public interface ActorMapper {
    int deleteByPrimaryKey(Short actorId);

    int insert(Actor record);

    Actor selectByPrimaryKey(Short actorId);

    List<Actor> selectAll();

    int updateByPrimaryKey(Actor record);
}