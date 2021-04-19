package com.learn.springsourcedemo.entity.dto;

import com.learn.springsourcedemo.entity.bo.HeadLine;
import com.learn.springsourcedemo.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
