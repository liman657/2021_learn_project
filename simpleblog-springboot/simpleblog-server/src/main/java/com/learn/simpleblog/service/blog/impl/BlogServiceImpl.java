package com.learn.simpleblog.service.blog.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.api.utils.QueryUtil;
import com.learn.simpleblog.module.domain.Blog;
import com.learn.simpleblog.module.mapper.BlogMapper;
import com.learn.simpleblog.service.blog.IBlogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:
 */
@Service("blogService")
public class BlogServiceImpl extends ServiceImpl<BlogMapper,Blog> implements IBlogService {

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        //构造分页数据
        IPage<Blog> page = new QueryUtil<Blog>().getQueryPage(params);

        List<Blog> blogList = baseMapper.pageCenterBlog(page,params);
        page.setRecords(blogList);

        return new PageUtil(page);
    }

}
