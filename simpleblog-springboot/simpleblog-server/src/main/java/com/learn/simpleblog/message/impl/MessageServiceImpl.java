package com.learn.simpleblog.message.impl;

import com.google.gson.Gson;
import com.learn.simpleblog.api.request.CommentRequest;
import com.learn.simpleblog.api.request.ConcernRequest;
import com.learn.simpleblog.api.request.ReplyRequest;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.message.IMessageService;
import com.learn.simpleblog.module.domain.*;
import com.learn.simpleblog.module.mapper.UserMsgMapper;
import com.learn.simpleblog.service.web.IIndexUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * autor:liman
 * createtime:2022/1/9
 * comment:
 */
@Slf4j
@Service("messageService")
public class MessageServiceImpl implements IMessageService {
    private static final Gson GSON=new Gson();

    @Autowired
    private UserMsgMapper userMsgMapper;

    @Autowired
    private IIndexUserService indexUserService;

    //@Async
    @Override
    public void sendMsg(UserMsg userMsg){
        try {
            //方式一：定时器轮询-pull的模式
            userMsgMapper.insertSelective(userMsg);

        }catch (Exception e){
            log.error("用户消息服务-发送");
        }
    }


    //转发
    @Override
    @Async
    public void forwardMsg(SysUserEntity entity, Blog blog, Blog srcBlog){
        try {
            String content=String.format(Constant.MsgModule.ForwardBlog.getContent(),entity.getName());
            UserMsg msg=new UserMsg(Constant.MsgModule.ForwardBlog.getCode(),blog.getId(),content,0,srcBlog.getUserId().intValue(),new Date());
            this.sendMsg(msg);
        }catch (Exception e){
            log.error("用户消息服务-转发模块");
        }
    }

    //评论
    @Override
    @Async
    public void commentMsg(CommentRequest request, Integer id, SysUserEntity user, Blog srcBlog){
        try {
            String content=String.format(Constant.MsgModule.Comment.getContent(),user.getName(),request.getContent());
            UserMsg msg=new UserMsg(Constant.MsgModule.Comment.getCode(),id,content,0,srcBlog.getUserId().intValue(),new Date());
            this.sendMsg(msg);
        }catch (Exception e){
            log.error("用户消息服务-评论模块");
        }
    }

    //回复
    @Override
    @Async
    public void replyMsg(ReplyRequest request, SysUserEntity entity, final Integer moduleId, final Integer msgUserId){
        try {
            String content=String.format(Constant.MsgModule.Reply.getContent(),entity.getName(),request.getContent());

            UserMsg msg=new UserMsg(Constant.MsgModule.Reply.getCode(),moduleId,content,0,msgUserId,new Date());
            this.sendMsg(msg);
        }catch (Exception e){
            log.error("用户消息服务-回复模块");
        }
    }

    //点赞
    @Override
    @Async
    public void praiseMsg(SysUserEntity entity, final Blog srcBlog, final Praise p){
        try {
            String content=String.format(Constant.MsgModule.Praise.getContent(),entity.getName());

            UserMsg msg=new UserMsg(Constant.MsgModule.Praise.getCode(),p.getId(),content,0,srcBlog.getUserId().intValue(),new Date());
            this.sendMsg(msg);
        }catch (Exception e){
            log.error("用户消息服务-点赞模块");
        }
    }


    //新粉丝关注
    @Override
    @Async
    public void concernMsg(ConcernRequest request, SysUserEntity entity, Concern concern){
        try {
            String content=String.format(Constant.MsgModule.Concern.getContent(),entity.getName());

            UserMsg msg=new UserMsg(Constant.MsgModule.Concern.getCode(),concern.getId(),content,0,request.getBeConcernUserId(),new Date());
            this.sendMsg(msg);
        }catch (Exception e){
            log.error("用户消息服务-新粉丝关注模块");
        }
    }
}
