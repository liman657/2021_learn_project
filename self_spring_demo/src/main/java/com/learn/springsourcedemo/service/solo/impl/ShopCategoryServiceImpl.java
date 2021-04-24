package com.learn.springsourcedemo.service.solo.impl;

import com.learn.springsourcedemo.entity.bo.ShopCategory;
import com.learn.springsourcedemo.entity.dto.Result;
import com.learn.springsourcedemo.service.solo.IShopCategoryService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * autor:liman
 * createtime:2021/4/22
 * comment:
 */
@Slf4j
public class ShopCategoryServiceImpl implements IShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
