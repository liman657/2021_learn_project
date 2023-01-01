package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Film;
import java.util.List;

public interface FilmMapper {
    int deleteByPrimaryKey(Short filmId);

    int insert(Film record);

    Film selectByPrimaryKey(Short filmId);

    List<Film> selectAll();

    int updateByPrimaryKey(Film record);
}