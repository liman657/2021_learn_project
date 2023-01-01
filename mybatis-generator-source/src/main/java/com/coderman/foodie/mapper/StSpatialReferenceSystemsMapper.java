package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.StSpatialReferenceSystems;
import java.util.List;

public interface StSpatialReferenceSystemsMapper {
    int insert(StSpatialReferenceSystems record);

    List<StSpatialReferenceSystems> selectAll();
}