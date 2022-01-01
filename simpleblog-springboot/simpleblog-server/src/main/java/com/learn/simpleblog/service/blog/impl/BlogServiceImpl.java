package com.learn.simpleblog.service.blog.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.api.utils.QueryUtil;
import com.learn.simpleblog.module.domain.Blog;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.module.mapper.*;
import com.learn.simpleblog.service.blog.IBlogService;
import com.learn.simpleblog.shiro.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:
 */
@Service("blogService")
@Slf4j
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Autowired
    private Environment environment;
    @Autowired
    private BlogImageMapper blogImageMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private PraiseMapper praiseMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ConcernMapper concernMapper;

    @Override
    public PageUtil queryPage(Map<String, Object> params) {
        //构造分页数据
        IPage<Blog> page = new QueryUtil<Blog>().getQueryPage(params);

        List<Blog> blogList = baseMapper.pageCenterBlog(page, params);

        //处理每篇博客额外的数据
        commonManageBlog(blogList);

        page.setRecords(blogList);
        return new PageUtil(page);
    }

    //通用的处理微博列表
    public List<Blog> commonManageBlog(List<Blog> list) {
        if (list != null && !list.isEmpty()) {
            list.forEach(this::commonManageSingleBlog);
        }
        return list;
    }

    //单独处理每条微博的额外的数据信息：微博图片、博主信息、是否已点赞/收藏/转发等信息
    public void commonManageSingleBlog(Blog blog) {
        try {
            Map<String, Object> otherMap = Maps.newHashMap();
            if (blog != null) {
                if (2 == blog.getType()) {//如果是转发的博客
                    //获取转发的微博
                    Blog fromBlog = baseMapper.selectByPK(blog.getBlogId());
                    if (null == fromBlog) {//原微博已经删除
                        //组装一个默认的微博内容
                        fromBlog = new Blog();
                        fromBlog.setContent(environment.getProperty("common.blog.delete.content"));
                        fromBlog.setNickName(environment.getProperty("common.blog.delete.nickName"));
                        fromBlog.setCreateTime(new Date());
                        fromBlog.setHeaderImg(environment.getProperty("common.user.img.blog.delete.default"));
                    } else {//如果原微博存在
                        //获取原微博的图片地址集合
                        List<String> imgUrls = blogImageMapper.selectByBlogId(blog.getBlogId(), environment.getProperty("common.file.access.root.url"));
                        fromBlog.setImgUrls(imgUrls);
                    }

                    //设置用户的头像
                    if (StringUtils.isBlank(fromBlog.getHeaderImg())) {//如果头像为空
                        fromBlog.setHeaderImg(environment.getProperty("common.user.img.default"));
                    }

                    //针对默认头像的路径处理
                    if (fromBlog.getHeaderImg().startsWith("/static")) {
                        fromBlog.setHeaderImg(environment.getProperty("common.user.img.root.url") + fromBlog.getHeaderImg());
                    } else {//不是默认头像
                        fromBlog.setHeaderImg(environment.getProperty("common.file.access.root.url") + fromBlog.getHeaderImg());
                    }
                    otherMap.put("fromBlog", fromBlog);
                } else {//如果不是转发的微博，就是自己发的微博
                    blog.setImgUrls(blogImageMapper.selectByBlogId(blog.getId(), environment.getProperty("common.file.access.root.url")));
                }

                //收藏，点赞，评论等数据
                try {
                    SysUserEntity userEntity = ShiroUtil.getUserEntity();
                    if (null != userEntity) {
                        //收藏
                        otherMap.put("hasCollect", collectMapper.countByUBlogId(blog.getId(), userEntity.getUserId()) > 0 ? 1 : 0);
                        //点赞
                        otherMap.put("hasPraise", praiseMapper.countByUBlogId(blog.getId(), userEntity.getUserId()) > 0 ? 1 : 0);
                        //转发
                        otherMap.put("hasForward", baseMapper.countByForwardBlog(userEntity.getUserId(), blog.getId()) > 0 ? 1 : 0);
                        //关注
                        otherMap.put("hasConcern", concernMapper.countByConcernBeId(userEntity.getUserId().intValue(), blog.getUserId().intValue()) > 0 ? 1 : 0);
                    }
                } catch (Exception e) {

                }
                //评论总数
                otherMap.put("commentTotal",commentMapper.countByBlogId(blog.getId()));
                blog.setOtherMap(otherMap);

                //设置用户头像
                if (StringUtils.isBlank(blog.getHeaderImg())){
                    blog.setHeaderImg(environment.getProperty("common.user.img.default"));
                }
                if (blog.getHeaderImg().startsWith("/statics")){
                    blog.setHeaderImg(environment.getProperty("common.user.img.root.url")+blog.getHeaderImg());
                }else{
                    blog.setHeaderImg(environment.getProperty("common.file.access.root.url")+blog.getHeaderImg());
                }
            }
        } catch (Exception e) {
            log.error("处理单条微博信息发生异常：", e);
        }
    }

}
