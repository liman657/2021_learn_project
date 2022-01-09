package com.learn.simpleblog.service.blog;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.module.domain.Blog;

import java.util.List;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:博客服务类接口
 */
public interface IBlogService extends IService<Blog> {

    PageUtil queryPage(Map<String, Object> params);

    /**
     * 计算转发微博的个数
     * @param userId
     * @param blogId
     * @return
     */
    int countByForwardBlog(Long userId, Integer blogId);

    /**
     * 获取点赞过的微博
     * @param params
     * @return
     */
    PageUtil queryPagePraises(Map<String, Object> params);

    /**
     * 获取收藏的微博
     * @param params
     * @return
     */
    PageUtil queryPageCollects(Map<String, Object> params);

    /**
     * 微博数据的二次处理
     * @param list
     * @return
     */
    List<Blog> commonManageBlog(List<Blog> list);

}
