package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.MetadataLocks;
import java.util.List;

public interface MetadataLocksMapper {
    int deleteByPrimaryKey(Long objectInstanceBegin);

    int insert(MetadataLocks record);

    MetadataLocks selectByPrimaryKey(Long objectInstanceBegin);

    List<MetadataLocks> selectAll();

    int updateByPrimaryKey(MetadataLocks record);
}