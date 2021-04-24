package com.learn.springsourcedemo.service.solo;

import com.learn.springsourcedemo.entity.bo.ShopCategory;
import com.learn.springsourcedemo.entity.dto.Result;

import java.util.List;

/**
 * autor:liman
 * createtime:2021/4/22
 * comment:
 */
public interface IShopCategoryService {

    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    Result<Boolean> removeShopCategory(int shopCategoryId);
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);
    Result<ShopCategory> queryShopCategoryById(int shopCategoryId);
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);

}
