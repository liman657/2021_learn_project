package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Carousel;
import java.util.List;

public interface CarouselMapper {
    int deleteByPrimaryKey(String id);

    int insert(Carousel record);

    Carousel selectByPrimaryKey(String id);

    List<Carousel> selectAll();

    int updateByPrimaryKey(Carousel record);
}