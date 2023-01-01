package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.SalesByStore;
import java.util.List;

public interface SalesByStoreMapper {
    int insert(SalesByStore record);

    List<SalesByStore> selectAll();
}