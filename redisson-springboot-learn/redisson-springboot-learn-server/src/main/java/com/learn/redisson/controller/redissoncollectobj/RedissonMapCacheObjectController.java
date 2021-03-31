package com.learn.redisson.controller.redissoncollectobj;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.common.RedisKeyConstant;
import com.learn.redisson.module.entity.MailInfo;
import com.learn.redisson.module.entity.User;
import com.learn.redisson.module.mapper.UserMapper;
import com.learn.redisson.server.IMapCacheService;
import com.learn.redisson.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.info;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 的分布式对象内容
 * mapcache拥有元素单独失效的功能，实现邮件的定时发送
 */
@Slf4j
@RequestMapping("/collobj")
@RestController
public class RedissonMapCacheObjectController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private IMapCacheService mapCacheService;
    //本地缓存映射的选项配置
    private LocalCachedMapOptions options;


    @RequestMapping(value = "/mapCache/emailsend", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse createEmail(@RequestBody @Validated MailInfo mailInfo, BindingResult result) {
        String checkRes=ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),checkRes);
        }
        if (mailInfo.getIsDelay().intValue()==1 && StringUtils.isBlank(mailInfo.getSendDateTime())){
            return new BaseResponse(StatusCode.MailInfoSendDateTimeInvalidated);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            mapCacheService.createMail(mailInfo);

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    //TODO:取消待发送邮件的定时发送
    @RequestMapping(value = "/mapCache/emailinvalid",method = RequestMethod.POST)
    public BaseResponse invalidateEmail(@RequestParam Integer id){
        if (id==null || id<=0){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            mapCacheService.invalidateEmail(id);

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

}
