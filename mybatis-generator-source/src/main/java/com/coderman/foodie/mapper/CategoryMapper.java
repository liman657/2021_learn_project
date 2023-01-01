package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Category;
import java.util.List;

public interface CategoryMapper {
    int insert(Category record);

    List<Category> selectAll();
}