package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SalesByFilmCategory;
import java.util.List;

public interface SalesByFilmCategoryMapper {
    int insert(SalesByFilmCategory record);

    List<SalesByFilmCategory> selectAll();
}