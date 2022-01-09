package com.learn.simpleblog.message;

import com.learn.simpleblog.api.request.CommentRequest;
import com.learn.simpleblog.api.request.ConcernRequest;
import com.learn.simpleblog.api.request.ReplyRequest;
import com.learn.simpleblog.module.domain.*;

/**
 * autor:liman
 * createtime:2022/1/9
 * comment:消息接口
 */
public interface IMessageService {

    /**
     * 发送消息
     * @param userMsg
     */
    public void sendMsg(UserMsg userMsg);

    /**
     * 转发时，发送消息
     * @param entity
     * @param blog
     * @param srcBlog
     */
    public void forwardMsg(SysUserEntity entity, Blog blog, Blog srcBlog);

    /**
     * 评论时发送消息
     * @param request
     * @param id
     * @param user
     * @param srcBlog
     */
    public void commentMsg(CommentRequest request, Integer id, SysUserEntity user, Blog srcBlog);

    /**
     * 回复发送消息
     * @param request
     * @param entity
     * @param moduleId
     * @param msgUserId
     */
    public void replyMsg(ReplyRequest request, SysUserEntity entity, final Integer moduleId, final Integer msgUserId);

    /**
     * 点赞发送消息
     * @param entity
     * @param srcBlog
     * @param p
     */
    public void praiseMsg(SysUserEntity entity, final Blog srcBlog, final Praise p);

    /**
     * 新粉丝关注发送消息
     * @param request
     * @param entity
     * @param concern
     */
    public void concernMsg(ConcernRequest request, SysUserEntity entity, Concern concern);
}
