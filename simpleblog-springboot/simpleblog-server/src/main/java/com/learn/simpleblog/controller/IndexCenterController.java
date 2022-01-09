package com.learn.simpleblog.controller;

import com.google.common.collect.Maps;
import com.learn.simpleblog.api.request.*;
import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.api.utils.ValidatorUtil;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.service.blog.IBlogService;
import com.learn.simpleblog.service.web.IIndexCenterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;
import java.util.Objects;

/**
 * autor:liman
 * createtime:2021/12/29
 * comment:微博简易版本前端门户网-数据展示与交互
 * 微博相关接口
 */
@Slf4j
@RestController
@RequestMapping("web/center")
public class IndexCenterController extends AbstractController{

    private static final Integer PageSize=10;

    @Autowired
    private IBlogService blogService;
    @Autowired
    private IIndexCenterService indexCenterService;

    @Autowired
    private Environment env;

    /**
     * 首页所有微博数据
     * @param paramMap
     * @return
     */
    //首页中心数据列表 - 向下滚动分页
    @RequestMapping(value = "data",method = RequestMethod.GET)
    public BaseResponse data(@RequestParam Map<String,Object> paramMap){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(indexCenterService.data(paramMap));
        }catch (Exception e){
            log.info("调用出现异常，异常信息为:{}",e);
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 用户个人信息
     * @return
     */
    //我的个人信息
    @RequestMapping(value = "info/my",method = RequestMethod.GET)
    public BaseResponse myInfo(){
        SysUserEntity entity=getUser();
        if (null == entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            //这里是获取用户额外的信息，比如粉丝人数
            response.setData(indexCenterService.getInfoByUId(entity.getUserId()));
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 发布微博
     * @param request
     * @param result
     * @return
     */
    //发微博
    @PostMapping("blog/send")
    public BaseResponse sendBlog(@RequestBody @Validated BlogRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes= ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }

        //敏感词的过滤 - 架构2.0

        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.sendBlog(request,entity.getUserId());
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 上传微博图片
     * @param request
     * @return
     */
    //选择图片(每上传一张就调用一次本接口，返回：图片的id和访问路径，再提交微博信息，将图片的id用,隔开拼接到一个字符串字段一起提及过来即可)
    @RequestMapping(value = "image/upload",method = RequestMethod.POST)
    public BaseResponse uploadImage(MultipartHttpServletRequest request){
        if (null==getUser()){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(indexCenterService.uploadImg(request));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 关注
     * @param request
     * @param result
     * @return
     */
    //关注
    @PostMapping("concern/on")
    public BaseResponse concernOn(@RequestBody @Validated ConcernRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.concernOn(request,entity);

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 取消关注
     * @param request
     * @param result
     * @return
     */
    //取消关注
    @PostMapping("concern/cancel")
    public BaseResponse concernCancel(@RequestBody @Validated ConcernRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.concernCancel(request,entity.getUserId());
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 点赞
     * @param request
     * @param result
     * @return
     */
    //点赞
    @PostMapping("praise/on")
    public BaseResponse praiseOn(@RequestBody @Validated OperationRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(indexCenterService.praiseOn(request,entity));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 取消点赞
     * @param request
     * @param result
     * @return
     */
    //取消点赞
    @PostMapping("praise/cancel")
    public BaseResponse praiseCancel(@RequestBody @Validated OperationRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.praiseCancel(request,entity.getUserId());

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 收藏
     * @param request
     * @param result
     * @return
     */
    //收藏
    @PostMapping("collect/on")
    public BaseResponse collectOn(@RequestBody @Validated OperationRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(indexCenterService.collectOn(request,entity.getUserId()));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 取消收藏
     * @param request
     * @param result
     * @return
     */
    //取消收藏
    @PostMapping("collect/cancel")
    public BaseResponse collectCancel(@RequestBody @Validated OperationRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.collectCancel(request,entity.getUserId());
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 评论
     * @param request
     * @param result
     * @return
     */
    //评论
    @PostMapping("comment/on")
    public BaseResponse commentOn(@RequestBody @Validated CommentRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        //敏感词的过滤 - 架构2.0
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.commentOn(request,entity);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 删除自己的微博
     * @param request
     * @param result
     * @return
     */
    //删除自己的微博
    @PostMapping("blog/delete")
    public BaseResponse deleteBlog(@RequestBody @Validated IdRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.deleteSelfBlog(request,entity);

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 回复
     * @param request
     * @param result
     * @return
     */
    //回复
    @PostMapping("reply/on")
    public BaseResponse replyOn(@RequestBody @Validated ReplyRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.replyOn(request,entity);

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 评论微博
     * @param blogId
     * @return
     */
    //获取微博的评论列表 - 每条评论下附带了回复列表
    @RequestMapping(value = "comments/blog",method = RequestMethod.GET)
    public BaseResponse comments(@RequestParam Integer blogId){
        if (Objects.isNull(blogId) || blogId<=0){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(indexCenterService.getCommentsByBlog(blogId));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 转发微博，不支持嵌套转发
     * @param request
     * @param result
     * @return
     */
    @PostMapping("blog/forward")
    public BaseResponse forwardBlog(@RequestBody @Validated BlogForwardRequest request, BindingResult result){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }

        //转发的微博内容是否含敏感词 - 架构2.0

        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            indexCenterService.forwardBlog(request,entity);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 我的微博
     * @param paramMap
     * @return
     */
    //我的微博 - 请求参数跟 “获取首页微博列表”的请求接口差不多 - 分页
    @RequestMapping(value = "blogs",method = RequestMethod.GET)
    public BaseResponse blogs(@RequestParam Map<String,Object> paramMap){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            paramMap.put("userId",entity.getUserId());
            response.setData(indexCenterService.getBlogByUserId(paramMap));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 我赞过的微博
     * @param paramMap
     * @return
     */
    //我的赞 ~ 我赞过的微博
    @RequestMapping(value = "praises/my",method = RequestMethod.GET)
    public BaseResponse myPraises(@RequestParam Map<String,Object> paramMap){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            paramMap.put("userId",entity.getUserId());
            response.setData(indexCenterService.getMyPraisesBlog(paramMap));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 我的收藏
     * @param paramMap
     * @return
     */
    //我的收藏
    @RequestMapping(value = "collects/my",method = RequestMethod.GET)
    public BaseResponse myCollects(@RequestParam Map<String,Object> paramMap){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            paramMap.put("userId",entity.getUserId());
            response.setData(indexCenterService.getMyCollectsBlog(paramMap));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    /**
     * 我的好友圈-查看我关注的人发的所有微博
     * @return
     */
    //我的好友圈-查看我关注的人发的所有微博
    @RequestMapping(value = "friends/my",method = RequestMethod.GET)
    public BaseResponse myFriends(){
        SysUserEntity entity=getUser();
        if (null==entity){
            return new BaseResponse(StatusCode.UserNotLogin);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            response.setData(indexCenterService.getMyFriendsBlog(entity.getUserId()));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}
