package com.learn.simpleblog.service.web.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.learn.simpleblog.api.request.BlogRequest;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.module.domain.Blog;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.module.mapper.BlogImageMapper;
import com.learn.simpleblog.module.mapper.BlogMapper;
import com.learn.simpleblog.module.mapper.ConcernMapper;
import com.learn.simpleblog.service.blog.IBlogService;
import com.learn.simpleblog.service.pmp.SysUserService;
import com.learn.simpleblog.service.web.IIndexCenterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private ConcernMapper concernMapper;
    @Autowired
    private BlogImageMapper blogImageMapper;
//    @Autowired
//    private LuceneBlogService luceneBlogService;

    @Override
    public Map<String, Object> data(Map<String, Object> paramMap) throws Exception {
        Map<String,Object> resMap= Maps.newHashMap();

        paramMap.put(Constant.LIMIT,PageSize);
        paramMap.put(Constant.PAGE,paramMap.get("pageNo"));
        resMap.put("blogList",blogService.queryPage(paramMap));
        return resMap;
    }

    //获取个人信息
    @Override
    public Map<String,Object> getInfoByUId(Long userId) throws Exception {
        Map<String,Object> resMap=Maps.newHashMap();

        SysUserEntity entity=sysUserService.getById(userId);
        entity.setPassword(null);
        entity.setSalt(null);

        //设置用户头像
        if (StringUtils.isBlank(entity.getImgUrl())){
            entity.setImgUrl(env.getProperty("common.user.img.default"));
        }
        if (entity.getImgUrl().startsWith("/statics")){
            entity.setImgUrl(env.getProperty("common.user.img.root.url")+entity.getImgUrl());
        }else{
            entity.setImgUrl(env.getProperty("common.file.access.root.url")+entity.getImgUrl());
        }

        //其他数据：粉丝数、关注数、微博数
        resMap.put("blogTotal",blogMapper.countByUserId(userId.intValue()));
        resMap.put("fansTotal",concernMapper.countFansByUserId(userId.intValue()));
        resMap.put("concernsTotal",concernMapper.countConcernsByUserId(userId.intValue()));

        resMap.put("userInfo",entity);
        return resMap;
    }

    //发微博
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer sendBlog(BlogRequest request, Long userId) throws Exception {
        //插入微博
        Blog blog=new Blog();
        /*blog.setContent(request.getContent());
        blog.setUserId(userId);
        blog.setType(1);
        blog.setCreateTime(DateTime.now().toDate());*/
        blog.setContent(request.getContent()).setUserId(userId).setType(1).setCreateTime(DateTime.now().toDate());
        blogService.save(blog);

        //插入微博图片
        if (StringUtils.isNotBlank(request.getImgIds())){
            String[] imgArr=StringUtils.split(request.getImgIds(),",");
            /*int length=imgArr.length;
            for (int i=0;i<length;i++){
                blogImageMapper.updateBlogById(blog.getId(),imgArr[i]);
            }*/

            //优化：批量更新
            blogImageMapper.updateBlogByIds(blog.getId(), Joiner.on(",").join(imgArr));
        }

        //更新底层lucene索引库的文档数据
//        luceneBlogService.createDocument(blogMapper.selectByPK(blog.getId()));

        return 1;
    }
}
