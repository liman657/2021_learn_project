package com.learn.redisson.controller.redissoncollectobj;

import com.learn.redisson.api.response.BaseResponse;
import com.learn.redisson.api.response.StatusCode;
import com.learn.redisson.module.entity.Problem;
import com.learn.redisson.module.entity.SysConfig;
import com.learn.redisson.server.IMultiMapService;
import com.learn.redisson.server.ISetObjService;
import com.learn.redisson.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
 * set集合，试题的随机获取
 */
@Slf4j
@RequestMapping("/collobj")
@RestController
public class RedissonSetObjectController {

    @Autowired
    private ISetObjService setObjService;

    //TODO:新增试题
    @RequestMapping(value = "/set/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse addProblem(@RequestBody @Validated Problem problem, BindingResult result) {
        String checkRes = ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(checkRes)) {
            return new BaseResponse(StatusCode.InvalidParams.getCode(), checkRes);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            response.setData(setObjService.addProblem(problem));

        } catch (Exception e) {
            log.error("新增试题-发生异常：", e);
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    //TODO:获取试题(所有)
    @RequestMapping(value = "/set/get", method = RequestMethod.GET)
    public BaseResponse getProblems() {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
//            response.setData(setObjService.getProblems());
            response.setData(setObjService.getProblemsRandom());
//            response.setData(setObjService.getProblemsV2());

        } catch (Exception e) {
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }

    //TODO:获取一道题目
    @RequestMapping(value = "/set/random", method = RequestMethod.GET)
    public BaseResponse random() {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            response.setData(setObjService.randomProblem());

        } catch (Exception e) {
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }


    //TODO:删除试题
    @RequestMapping(value = "/set/delete", method = RequestMethod.POST)
    public BaseResponse deleteProblem(@RequestParam Integer id) {
        if (id == null || id <= 0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            response.setData(setObjService.deleteProblem(id));

        } catch (Exception e) {
            response = new BaseResponse(StatusCode.Fail.getCode(), e.getMessage());
        }
        return response;
    }
}
