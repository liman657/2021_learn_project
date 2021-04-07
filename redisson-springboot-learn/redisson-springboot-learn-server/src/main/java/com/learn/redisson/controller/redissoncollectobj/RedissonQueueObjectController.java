package com.learn.redisson.controller.redissoncollectobj;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.module.entity.Notice;
import com.learn.redisson.module.entity.Problem;
import com.learn.redisson.server.IQueueService;
import com.learn.redisson.server.ISetObjService;
import com.learn.redisson.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * autor:liman
 * createtime:2021/3/13
 * comment: redisson 的分布式对象内容
 * set集合，试题的随机获取
 */
@Slf4j
@RequestMapping("/collobj")
@RestController
public class RedissonQueueObjectController {

    @Autowired
    private IQueueService queueService;

    @RequestMapping(value = "/notice/push", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse addProblem(@RequestBody @Validated Notice notice, BindingResult result) {
        String checkRes = ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)) {
            return new BaseResponse(StatusCode.InvalidParams.getCode(), checkRes);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            response.setData(queueService.createNotice(notice));
        } catch (Exception e) {
            log.error("消息推送-发生异常：", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

}
