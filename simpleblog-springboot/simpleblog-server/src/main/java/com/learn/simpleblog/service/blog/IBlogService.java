package com.learn.simpleblog.service.blog;

import com.learn.simpleblog.api.utils.PageUtil;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:博客服务类接口
 */
public interface IBlogService {

    PageUtil queryPage(Map<String, Object> params);

}
