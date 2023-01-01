package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbTablespaces;
import java.util.List;

public interface InnodbTablespacesMapper {
    int insert(InnodbTablespaces record);

    List<InnodbTablespaces> selectAll();
}