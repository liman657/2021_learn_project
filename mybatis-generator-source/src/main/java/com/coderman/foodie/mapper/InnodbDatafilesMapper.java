package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbDatafiles;
import java.util.List;

public interface InnodbDatafilesMapper {
    int insert(InnodbDatafiles record);

    List<InnodbDatafiles> selectAll();
}