package com.learn.simpleblog.service.web.impl;

import com.google.common.collect.Maps;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.service.blog.IBlogService;
import com.learn.simpleblog.service.web.IIndexCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:博客的首页数据服务类
 */
@Service
@Slf4j
public class IndexCenterServiceImpl implements IIndexCenterService {
    private static final Integer PageSize=10;
    @Autowired
    private Environment env;
    @Autowired
    private IBlogService blogService;

    @Override
    public Map<String, Object> data(Map<String, Object> paramMap) throws Exception {
        Map<String,Object> resMap= Maps.newHashMap();

        paramMap.put(Constant.LIMIT,PageSize);
        paramMap.put(Constant.PAGE,paramMap.get("pageNo"));
        resMap.put("blogList",blogService.queryPage(paramMap));
        return resMap;
    }
}
