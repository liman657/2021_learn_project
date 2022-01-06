package com.learn.simpleblog.service.blog;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.module.domain.Blog;

import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:博客服务类接口
 */
public interface IBlogService extends IService<Blog> {

    PageUtil queryPage(Map<String, Object> params);

}
