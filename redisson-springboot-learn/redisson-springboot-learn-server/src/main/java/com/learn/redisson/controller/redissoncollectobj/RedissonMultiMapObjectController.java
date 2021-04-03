package com.learn.redisson.controller.redissoncollectobj;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.module.entity.MailInfo;
import com.learn.redisson.module.entity.SysConfig;
import com.learn.redisson.module.mapper.UserMapper;
import com.learn.redisson.server.IMapCacheService;
import com.learn.redisson.server.IMultiMapService;
import com.learn.redisson.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 的分布式对象内容
 * mapcache拥有元素单独失效的功能，实现邮件的定时发送
 */
@Slf4j
@RequestMapping("/collobj")
@RestController
public class RedissonMultiMapObjectController {

    @Autowired
    private IMultiMapService multiMapService;


    @RequestMapping(value = "/multiMap/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse createEmail(@RequestBody @Validated SysConfig sysConfig, BindingResult result) {
        String checkRes = ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            log.info("开始出入数据字典配置数据:{}", sysConfig);
            multiMapService.insertConfigData(sysConfig);
        } catch (Exception e) {
            log.warn("插入数据字典数据出现异常，异常信息为:{}", e);
        }
        return response;
    }

    @RequestMapping(value = "multiMap/get", method = RequestMethod.GET)
    public BaseResponse getConfig(@RequestParam String typeCode) {
        if (StringUtils.isBlank(typeCode)) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            log.info("查询配置信息参数为:{}", typeCode);
            Collection<SysConfig> data = multiMapService.getConfigTypeList(typeCode);
            response.setData(data);
        } catch (Exception e) {
            log.warn("查询配置信息出现异常，异常信息为:{}", e);
        }
        return response;
    }

    //TODO:删除选项列表
    @RequestMapping(value = "multiMap/delete", method = RequestMethod.GET)
    public BaseResponse deleteConfig(@RequestParam Integer id) {
        if (id == null || id <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            log.info("删除配置信息的参数为:{}", id);
            response.setData(multiMapService.deleteConfig(id));

        } catch (Exception e) {
            log.warn("删除配置信息出现异常，异常信息为:{}", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

}
