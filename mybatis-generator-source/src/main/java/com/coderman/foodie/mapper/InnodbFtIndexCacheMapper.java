package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.InnodbFtIndexCache;
import java.util.List;

public interface InnodbFtIndexCacheMapper {
    int insert(InnodbFtIndexCache record);

    List<InnodbFtIndexCache> selectAll();
}