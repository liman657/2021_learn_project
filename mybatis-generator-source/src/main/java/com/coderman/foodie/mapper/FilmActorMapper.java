package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.FilmActor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilmActorMapper {
    int deleteByPrimaryKey(@Param("actorId") Short actorId, @Param("filmId") Short filmId);

    int insert(FilmActor record);

    FilmActor selectByPrimaryKey(@Param("actorId") Short actorId, @Param("filmId") Short filmId);

    List<FilmActor> selectAll();

    int updateByPrimaryKey(FilmActor record);
}