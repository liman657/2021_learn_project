package com.learn.simpleblog.service.web.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.learn.simpleblog.api.exception.CommonException;
import com.learn.simpleblog.api.request.*;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.common.CommonService;
import com.learn.simpleblog.common.SysModule;
import com.learn.simpleblog.lucene.LuceneBlogService;
import com.learn.simpleblog.message.IMessageService;
import com.learn.simpleblog.module.domain.*;
import com.learn.simpleblog.module.mapper.*;
import com.learn.simpleblog.service.blog.IBlogService;
import com.learn.simpleblog.service.pmp.SysUserService;
import com.learn.simpleblog.service.web.IIndexCenterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
    @Autowired
    private CommonService commonService;
    @Autowired
    private IMessageService messageService;
    @Autowired
    private PraiseMapper praiseMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private LuceneBlogService luceneBlogService;

    /**
     * 查询所有博客记录，分页
     * @param paramMap
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> data(Map<String, Object> paramMap) throws Exception {
        Map<String,Object> resMap= Maps.newHashMap();

        paramMap.put(Constant.LIMIT,PageSize);
        paramMap.put(Constant.PAGE,paramMap.get("pageNo"));
        resMap.put("blogList",blogService.queryPage(paramMap));
        return resMap;
    }

    /**
     * 获取个人信息
     * @param userId
     * @return
     * @throws Exception
     */
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

    /**
     * 发微博
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
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
            //批量更新图片
            blogImageMapper.updateBlogByIds(blog.getId(), Joiner.on(",").join(imgArr));
        }

        //更新底层lucene索引库的文档数据
        luceneBlogService.createDocument(blogMapper.selectByPK(blog.getId()));

        return 1;
    }

    /**
     * 上传微博图片
     * @param request
     * @return
     * @throws Exception
     */
    //上传微博图片
    @Override
    public Map<String, Object> uploadImg(MultipartHttpServletRequest request) throws Exception {
        Map<String, Object> resMap=Maps.newHashMap();

        MultipartFile multipartFile=request.getFile("img");
        Map<String,Object> dataMap=commonService.uploadV2(multipartFile, SysModule.ModuleBlog);

        BlogImage image=new BlogImage(String.valueOf(dataMap.get("fileName")),String.valueOf(dataMap.get("size")),String.valueOf(dataMap.get("suffix")),String.valueOf(dataMap.get("fileUrl")));
        blogImageMapper.insertSelective(image);

        resMap.put("imgId",image.getId());
        resMap.put("imgUrl",env.getProperty("common.file.access.root.url")+dataMap.get("fileUrl"));
        return resMap;
    }

    /**
     * 关注
     * @param request
     * @param entity
     * @return
     * @throws Exception
     */
    //关注：当前用户为关注者，前端提交被关注者id过来即可
    @Override
    public Integer concernOn(ConcernRequest request, SysUserEntity entity) throws Exception {
        if (concernMapper.countByConcernBeId(entity.getUserId().intValue(),request.getBeConcernUserId())<=0){
            if (!Objects.equals(request.getBeConcernUserId(),entity.getUserId().intValue())){
                Concern concern=new Concern(entity.getUserId().intValue(),request.getBeConcernUserId(),DateTime.now().toDate());
                int res=concernMapper.insertSelective(concern);

                //消息服务
                if (res>0){
                    //用户关注，发送消息
                    messageService.concernMsg(request,entity,concern);
                }
                return 1;
            }
        }
        return -1;
    }

    /**
     * 取消关注
     * @param request
     * @param userId
     * @return
     * @throws Exception
     */
    //取消关注
    @Override
    public Integer concernCancel(ConcernRequest request, Long userId) throws Exception {
        return concernMapper.deleteByConcernBeId(userId.intValue(),request.getBeConcernUserId());
    }

    /**
     * 点赞
     * @param request
     * @param entity
     * @return
     * @throws Exception
     */
    //点赞-先判断当前用户是否点赞过当前微博
    @Override
    public Integer praiseOn(OperationRequest request, SysUserEntity entity) throws Exception {
        Praise p=praiseMapper.selectByUBlogId(request.getBlogId(),entity.getUserId());
        if (null!=p && p.getStatus()==1) {
            return 1;
        }
        if (null!=p){
            //取消点赞
            p.setStatus(1);
            p.setUpdateTime(DateTime.now().toDate());
            praiseMapper.updateByPrimaryKeySelective(p);
        }else{
            //点赞
            p=new Praise(request.getBlogId(),entity.getUserId().intValue(),DateTime.now().toDate(),1);
            praiseMapper.insertSelective(p);
        }

        //消息服务
        Blog srcBlog=blogMapper.selectByPK(request.getBlogId());
        if (!Objects.isNull(srcBlog) && !Objects.equals(entity.getUserId(),srcBlog.getUserId())){
            messageService.praiseMsg(entity,srcBlog,p);
        }
        return 1;
    }

    //取消点赞 ~ 前端得判断当前微博的作者 与 发起取消点赞动作的人 是否为同一个（即只能 取消点赞 自己 点赞 过的微博）
    @Override
    public Integer praiseCancel(OperationRequest request, Long userId) throws Exception {
        //方式一
        return praiseMapper.deleteByUBlogId(request.getBlogId(),userId);

        //方式二：更新点赞记录的status=0
    }

    //收藏
    @Override
    public Integer collectOn(OperationRequest request, Long userId) throws Exception {
        Collect c=collectMapper.selectByUBlogId(request.getBlogId(),userId);
        if (null!=c && c.getStatus()==1) {
            return 1;
        }
        if (null!=c){
            //取消收藏
            c.setStatus(1);
            c.setUpdateTime(DateTime.now().toDate());
            collectMapper.updateByPrimaryKeySelective(c);
        }else{
            //收藏
            c=new Collect(request.getBlogId(),userId.intValue(),DateTime.now().toDate(),1);
            collectMapper.insertSelective(c);
        }
        return 1;
    }

    //取消收藏
    @Override
    public Integer collectCancel(OperationRequest request, Long userId) throws Exception {
        return collectMapper.deleteByUBlogId(request.getBlogId(),userId);
    }

    //发评论
    @Override
    public Integer commentOn(CommentRequest request, SysUserEntity user) throws Exception {
        Comment comment=new Comment(request.getBlogId(),user.getUserId().intValue(),request.getContent(),DateTime.now().toDate(),1);
        int res=commentMapper.insertSelective(comment);

        //消息服务
        Blog srcBlog=blogMapper.selectByPK(request.getBlogId());
        if (res>0 && !Objects.isNull(srcBlog) && !Objects.equals(srcBlog.getUserId(),user.getUserId())){
            messageService.commentMsg(request,comment.getId(),user,srcBlog);
        }
        return 1;
    }

    //发起回复：如果是评论，则不需要传“被回复者”，否则需要将 被回复者 的昵称传过来
    @Override
    public Integer replyOn(ReplyRequest request, SysUserEntity entity) throws Exception {
        Comment c=commentMapper.selectByPrimaryKey(request.getCommentId());
        if (null!=c && c.getStatus().equals(1) && !Objects.equals(c.getUserId(),entity.getUserId().intValue())){
            Reply reply=new Reply(request.getBlogId(),request.getCommentId(),entity.getUserId().intValue(),request.getContent(),entity.getName(),DateTime.now().toDate(),1);
            int res=replyMapper.insertSelective(reply);

            //消息服务
            if (res>0 && !Objects.equals(entity.getUserId().intValue(),c.getUserId())){
                messageService.replyMsg(request,entity,reply.getId(),c.getUserId());
            }
        }
        return 1;
    }

    //删除微博 - 只能删除自己的
    @Override
    public Integer deleteSelfBlog(IdRequest request, SysUserEntity entity) throws Exception {
        Blog blog=blogMapper.selectByPK(request.getId());
        if (null!=blog && Objects.equals(blog.getUserId(),entity.getUserId())){
            int res=blogMapper.deleteById(request.getId());

            //更新底层索引库
            if (res>0){
                luceneBlogService.deleteDocument(request.getId());
            }
        }
        return -1;
    }

    //获取微博下的评论列表
    @Override
    public List<Comment> getCommentsByBlog(Integer blogId) throws Exception {
        List<Comment> list=commentMapper.selectByBlogId(blogId);
        if (!CollectionUtils.isEmpty(list)){
            list.forEach(c -> {
                //遍历每一条评论数据，获取回复数据列表
                List<Reply> replies=replyMapper.selectByCommentId(c.getId());
                if (!CollectionUtils.isEmpty(replies)){
                    replies.forEach(r -> {
                        //设置用户头像
                        if (StringUtils.isBlank(r.getHeaderImg())){
                            r.setHeaderImg(env.getProperty("common.user.img.default"));
                        }
                        if (r.getHeaderImg().startsWith("/statics")){
                            r.setHeaderImg(env.getProperty("common.user.img.root.url")+r.getHeaderImg());
                        }else{
                            r.setHeaderImg(env.getProperty("common.file.access.root.url")+r.getHeaderImg());
                        }
                    });
                }

                //设置评论下的回复数据
                c.setReplys(replies);

                //设置评论者的头像
                if (StringUtils.isBlank(c.getHeaderImg())){
                    c.setHeaderImg(env.getProperty("common.user.img.default"));
                }
                if (c.getHeaderImg().startsWith("/statics")){
                    c.setHeaderImg(env.getProperty("common.user.img.root.url")+c.getHeaderImg());
                }else{
                    c.setHeaderImg(env.getProperty("common.file.access.root.url")+c.getHeaderImg());
                }
            });
        }
        return list;
    }

    //转发微博 - 判断当前用户是否已转发当前微博;判断待转发的微博是否存在;不能转发自己的微博；不能转发 类型为 "转发 type=2"的微博
    @Override
    public Integer forwardBlog(BlogForwardRequest request, SysUserEntity entity) throws Exception {
        int total=blogService.countByForwardBlog(entity.getUserId(),request.getBlogId());
        if (total>0){
            throw new CommonException("您已经转发过该微博了！");
        }
        Blog srcBlog=blogService.getById(request.getBlogId());
        if (Objects.isNull(srcBlog)){
            throw new CommonException("待转发的微博已不存在！");
        }
        if (Objects.equals(srcBlog.getUserId(),entity.getUserId())){
            throw new CommonException("不能转发自己的微博！");
        }
        if (Objects.equals(2,srcBlog.getType())){
            throw new CommonException("请找到最原始的博客再点击进行转发！");
        }

        //插入转发微博数据
        Blog blog=new Blog();
        blog.setContent(StringUtils.isNotBlank(request.getContent())?request.getContent():"转发了...");
        blog.setUserId(entity.getUserId());
        blog.setType(2);//2为转发类型
        blog.setBlogId(request.getBlogId());
        blog.setCreateTime(DateTime.now().toDate());
        Boolean res=blogService.save(blog);

        //消息服务
        if (res){
            messageService.forwardMsg(entity,blog,srcBlog);

            //更新底层lucene索引库的文档数据
            luceneBlogService.createDocument(blogMapper.selectByPK(blog.getId()));
        }
        return 1;
    }

    /**
     * 底层还是调用的data方法
     * @param paramMap
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> getBlogByUserId(Map<String, Object> paramMap) throws Exception {
        return this.data(paramMap);
    }

    //我赞过的微博
    @Override
    public Map<String,Object> getMyPraisesBlog(Map<String,Object> paramMap) throws Exception {
        Map<String,Object> resMap=Maps.newHashMap();

        paramMap.put(Constant.LIMIT,PageSize);
        paramMap.put(Constant.PAGE,paramMap.get("pageNo"));

        //可重复用
        resMap.put("blogList",blogService.queryPagePraises(paramMap));

        return resMap;
    }

    //我收藏的微博
    @Override
    public Map<String,Object> getMyCollectsBlog(Map<String,Object> paramMap) throws Exception {
        Map<String,Object> resMap=Maps.newHashMap();

        paramMap.put(Constant.LIMIT,PageSize);
        paramMap.put(Constant.PAGE,paramMap.get("pageNo"));
        resMap.put("blogList",blogService.queryPageCollects(paramMap));

        return resMap;
    }

    /**
     * 获取我关注的人所发的微博列表
     * @param userId
     * @return
     * @throws Exception
     */
    //获取我关注的人所发的微博列表
    @Override
    public List<Blog> getMyFriendsBlog(Long userId) throws Exception {
        List<Blog> list= Lists.newLinkedList();

        //方式一
        Set<Integer> friends=concernMapper.selectMyConcerns(userId.intValue());
        if (!CollectionUtils.isEmpty(friends)){
            String userIds=Joiner.on(",").join(friends);
            list=blogMapper.selectBlogByUIds(userIds);

            //做下二次处理
            blogService.commonManageBlog(list);
        }


        //方式二：join方法 - 交给你了！！

        return list;
    }

    //数据初始化-Lucene
    @Override
    public void initLuceneData() throws Exception {
        List<Blog> list=blogMapper.selectAll();
        if (list!=null && !list.isEmpty()){
            list.forEach(blog -> {
                try {
                    luceneBlogService.createDocument(blog);
                }catch (Exception e){e.printStackTrace();}
            });
        }
    }

    //门户网首页全文检索-lucene
    @Override
    public Map<String, Object> dataSearchLucene(Map<String,Object> paramMap) throws Exception {
        Map<String,Object> resMap= Maps.newHashMap();

        Integer pageNo=Integer.valueOf(Objects.isNull(paramMap.get("pageNo")) ? "1" : paramMap.get("pageNo").toString());

        if (paramMap.get("searchText")!=null && StringUtils.isNotBlank(paramMap.get("searchText").toString())){
            resMap.put("blogList",luceneBlogService.searchDocumentPage(paramMap.get("searchText").toString(),PageSize,pageNo));
        }else{
            resMap=this.data(paramMap);
        }
        return resMap;
    }
}