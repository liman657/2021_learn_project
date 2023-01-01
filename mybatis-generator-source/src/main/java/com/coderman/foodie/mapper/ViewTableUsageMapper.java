package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.ViewTableUsage;
import java.util.List;

public interface ViewTableUsageMapper {
    int insert(ViewTableUsage record);

    List<ViewTableUsage> selectAll();
}