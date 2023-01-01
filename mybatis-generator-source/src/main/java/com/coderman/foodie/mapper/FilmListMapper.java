package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.FilmList;
import java.util.List;

public interface FilmListMapper {
    int insert(FilmList record);

    List<FilmList> selectAll();
}