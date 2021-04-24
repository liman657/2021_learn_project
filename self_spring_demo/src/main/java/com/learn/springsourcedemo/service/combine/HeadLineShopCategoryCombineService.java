package com.learn.springsourcedemo.service.combine;

import com.learn.springsourcedemo.entity.dto.MainPageInfoDTO;
import com.learn.springsourcedemo.entity.dto.Result;

/**
 * autor:liman
 * createtime:2021/4/22
 * comment:
 */
public interface HeadLineShopCategoryCombineService {

    Result<MainPageInfoDTO> getMainPageInfo();

}
