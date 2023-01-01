package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Version;
import java.util.List;

public interface VersionMapper {
    int insert(Version record);

    List<Version> selectAll();
}