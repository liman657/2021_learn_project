package com.learn.simpleblog.service.web.impl;

import com.google.common.collect.Maps;
import com.learn.simpleblog.api.request.IdRequest;
import com.learn.simpleblog.api.request.UserRequest;
import com.learn.simpleblog.api.utils.Constant;
import com.learn.simpleblog.common.CommonService;
import com.learn.simpleblog.common.SysModule;
import com.learn.simpleblog.module.domain.SysUserEntity;
import com.learn.simpleblog.module.domain.UserMsg;
import com.learn.simpleblog.module.mapper.SysUserDao;
import com.learn.simpleblog.module.mapper.UserMsgMapper;
import com.learn.simpleblog.service.pmp.SysUserService;
import com.learn.simpleblog.service.web.IIndexUserService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.*;
import java.util.function.Consumer;

@Service("indexUserService")
@EnableAsync
public class IndexUserServiceImpl implements IIndexUserService {

    private static final Logger log= LoggerFactory.getLogger(IndexUserServiceImpl.class);

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private Environment env;

    @Autowired
    private UserMsgMapper userMsgMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SysUserDao sysUserDao;



    //用户注册
    public Boolean registerUser(UserRequest userRequest) throws Exception{
        SysUserEntity entity=new SysUserEntity();
        BeanUtils.copyProperties(userRequest,entity);

        //设置默认的用户头像
        entity.setImgUrl(env.getProperty("common.user.img.default"));
        sysUserService.saveUser(entity);
        return true;
    }

    //用户信息更改
    public Boolean updateUser(UserRequest userRequest) throws Exception{
        SysUserEntity entity=new SysUserEntity();
        BeanUtils.copyProperties(userRequest,entity);

        sysUserService.updateUser(entity);
        return true;
    }


    //上传用户头像
    @Transactional(rollbackFor = Exception.class)
    public String uploadImg(MultipartHttpServletRequest request,Long userId) throws Exception{
        Map<String,Object> resMap=Maps.newHashMap();

        MultipartFile multipartFile=request.getFile("img");
        Map<String,Object> dataMap=commonService.uploadV2(multipartFile, SysModule.ModuleUser);

        //图片上传之后，更新用户信息
        sysUserDao.updateUserImg(userId,String.valueOf(dataMap.get("fileUrl")));
        return env.getProperty("common.file.access.root.url") + dataMap.get("fileUrl");
    }


    //用户消息 - 获取5大模块下的消息数据
    @Override
    public Map<String, Object> getUserMsg(Integer userId) throws Exception {
        Map<String, Object> resMap=Maps.newHashMap();

        if (!Objects.isNull(userId)){
            List<Constant.MsgModule> list=Arrays.asList(Constant.MsgModule.values());
            list.forEach(new Consumer<Constant.MsgModule>() {
                @Override
                public void accept(Constant.MsgModule m) {
                    //获取当前用户（消息的接受者）每个消息模块的所有消息列表（未读的在前面） - 取出的消息数据只限N条 同时 统计未读的消息的总数
                    List<UserMsg> msg=userMsgMapper.selectByModuleUIdIsRead(m.getCode(),userId,null);
                    resMap.put(m.getCode(),msg);

                    resMap.put(m.getCode()+"-unRead",userMsgMapper.countModuleUIdIsRead(m.getCode(),userId,0));
                }
            });
        }

        return resMap;
    }

    //读消息
    @Override
    public Boolean readMsg(IdRequest request, Long userId) throws Exception {
        UserMsg msg=userMsgMapper.selectByPrimaryKey(request.getId());
        if (!Objects.isNull(msg) && msg.getReceiverId().equals(userId.intValue()) && Objects.equals(0,msg.getIsDelete()) && Objects.equals(0,msg.getIsRead())){
            msg.setIsRead(1);
            msg.setReadTime(DateTime.now().toDate());
            msg.setUpdateTime(DateTime.now().toDate());
            userMsgMapper.updateByPrimaryKey(msg);
            return true;
        }
        return null;
    }
}



































