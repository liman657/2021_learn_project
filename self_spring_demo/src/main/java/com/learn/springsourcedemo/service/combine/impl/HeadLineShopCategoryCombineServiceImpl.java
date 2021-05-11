package com.learn.springsourcedemo.service.combine.impl;


import com.learn.self.springframework.core.annotation.Service;
import com.learn.springsourcedemo.entity.bo.HeadLine;
import com.learn.springsourcedemo.entity.bo.ShopCategory;
import com.learn.springsourcedemo.entity.dto.MainPageInfoDTO;
import com.learn.springsourcedemo.entity.dto.Result;
import com.learn.springsourcedemo.service.combine.HeadLineShopCategoryCombineService;
import com.learn.springsourcedemo.service.solo.IHeadLineService;
import com.learn.springsourcedemo.service.solo.IShopCategoryService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {
    private IHeadLineService headLineService;
    private IShopCategoryService shopCategoryService;
    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> HeadLineResult = headLineService.queryHeadLine(headLineCondition, 1, 4);
        //2.获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult =shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        //3.合并两者并返回
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(HeadLineResult, shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult, Result<List<ShopCategory>> shopCategoryResult) {
        return  null;
    }
}
