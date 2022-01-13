package com.learn.simpleblog.service.web;

import com.learn.simpleblog.api.request.*;
import com.learn.simpleblog.module.domain.Blog;
import com.learn.simpleblog.module.domain.Comment;
import com.learn.simpleblog.module.domain.SysUserEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:
 */
public interface IIndexCenterService {

    /**
     * 获取博客列表数据
     * @param paramMap
     * @return
     * @throws Exception
     */
    Map<String,Object> data(Map<String, Object> paramMap) throws Exception;

    Map<String,Object> getInfoByUId(Long userId) throws Exception;

    /**
     * 发布博客
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
    public Integer sendBlog(BlogRequest request, Long userId) throws Exception;

    /**
     * 上传微博图片
     * @param request
     * @return
     */
    public Map<String, Object> uploadImg(MultipartHttpServletRequest request) throws Exception;

    /**
     * 关注
     * @param request
     * @param entity
     * @return
     * @throws Exception
     */
    public Integer concernOn(ConcernRequest request, SysUserEntity entity) throws Exception;

    /**
     * 取消关注
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
    public Integer concernCancel(ConcernRequest request, Long userId) throws Exception;

    /**
     * 点赞
     * @param request
     * @param entity
     * @return
     * @throws Exception
     */
    Integer praiseOn(OperationRequest request, SysUserEntity entity) throws Exception;

    /**
     * 取消点赞
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
    Integer praiseCancel(OperationRequest request, Long userId) throws Exception;

    /**
     * 收藏
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
    Integer collectOn(OperationRequest request, Long userId) throws Exception;

    /**
     * 取消收藏
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
    Integer collectCancel(OperationRequest request, Long userId) throws Exception;

    /**
     * 发表评论
     * @param request
     * @param entity
     * @return
     * @throws Exception
     */
    Integer commentOn(CommentRequest request, SysUserEntity entity) throws Exception;

    /**
     * 评论某个微博
     * @param request
     * @param entity
     * @return
     * @throws Exception
     */
    Integer replyOn(ReplyRequest request, SysUserEntity entity) throws Exception;

    /**
     * 删除自己的微博
     * @param request
     * @param entity
     * @return
     * @throws Exception
     */
    Integer deleteSelfBlog(IdRequest request, SysUserEntity entity) throws Exception;

    /**
     * 获取某个微博的评论
     * @param blogId
     * @return
     * @throws Exception
     */
    List<Comment> getCommentsByBlog(Integer blogId) throws Exception;

    /**
     * 转发微博
     * @param request
     * @param entity
     * @return
     * @throws Exception
     */
    Integer forwardBlog(BlogForwardRequest request, SysUserEntity entity) throws Exception;

    /**
     * 获取我的微博或者别人已发的微博
     * @param paramMap
     * @return
     * @throws Exception
     */
    Map<String,Object> getBlogByUserId(Map<String, Object> paramMap) throws Exception;

    /**
     * 获取点赞的微博
     * @param paramMap
     * @return
     * @throws Exception
     */
    Map<String,Object> getMyPraisesBlog(Map<String, Object> paramMap) throws Exception;

    /**
     * 获取我收藏的微博
     * @param paramMap
     * @return
     * @throws Exception
     */
    Map<String,Object> getMyCollectsBlog(Map<String, Object> paramMap) throws Exception;

    /**
     * 获取所关注的人发的微博列表
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Blog> getMyFriendsBlog(Long userId) throws Exception;

    /**
     * Lucene数据初始化
     * @throws Exception
     */
    public void initLuceneData() throws Exception;

    /**
     * lucene数据查询
     * @param paramMap
     * @return
     * @throws Exception
     */
    public Map<String, Object> dataSearchLucene(Map<String,Object> paramMap) throws Exception;
}
