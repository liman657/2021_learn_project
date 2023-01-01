package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Store;
import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Byte storeId);

    int insert(Store record);

    Store selectByPrimaryKey(Byte storeId);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);
}