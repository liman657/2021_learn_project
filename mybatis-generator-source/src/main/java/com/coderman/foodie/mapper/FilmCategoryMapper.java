package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.FilmCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FilmCategoryMapper {
    int deleteByPrimaryKey(@Param("filmId") Short filmId, @Param("categoryId") Byte categoryId);

    int insert(FilmCategory record);

    FilmCategory selectByPrimaryKey(@Param("filmId") Short filmId, @Param("categoryId") Byte categoryId);

    List<FilmCategory> selectAll();

    int updateByPrimaryKey(FilmCategory record);
}