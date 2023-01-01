package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Files;
import java.util.List;

public interface FilesMapper {
    int insert(Files record);

    List<Files> selectAll();
}