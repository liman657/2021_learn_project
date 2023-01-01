package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbTablespacesBrief;
import java.util.List;

public interface InnodbTablespacesBriefMapper {
    int insert(InnodbTablespacesBrief record);

    List<InnodbTablespacesBrief> selectAll();
}