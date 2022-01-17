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

    /**
     * 处理每条微博的数据
     * @param blog
     */
    public void commonManageSingleBlog(Blog blog);

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

    /**
     * 管理员查看博客数据
     * @param params
     * @return
     */
    PageUtil queryPageAdmin(Map<String, Object> params);

    /**
     * 管理员删除博客实体数据
     * @param ids
     */
    void deleteEntity(List<Integer> ids);

    /**
     * 管理员激活博客实体数据
     * @param ids
     */
    void activeEntity(List<Integer> ids);

}
