package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.NicerButSlowerFilmList;
import java.util.List;

public interface NicerButSlowerFilmListMapper {
    int insert(NicerButSlowerFilmList record);

    List<NicerButSlowerFilmList> selectAll();
}