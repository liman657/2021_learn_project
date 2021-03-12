package com.learn.redisson.module.mapper;

import com.learn.redisson.module.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    Set<String> selectAllCodes();

    int insertBatch(@Param("datas") List<Item> datas);
}