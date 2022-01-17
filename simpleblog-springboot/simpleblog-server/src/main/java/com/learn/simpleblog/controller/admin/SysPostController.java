package com.learn.simpleblog.controller.admin;

import com.google.common.collect.Maps;
import com.learn.simpleblog.annotation.LogAnnotation;
import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.api.utils.ValidatorUtil;
import com.learn.simpleblog.controller.AbstractController;
import com.learn.simpleblog.module.domain.SysPostEntity;
import com.learn.simpleblog.service.pmp.SysPostService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 岗位管理controller
 * @Author:debug (SteadyJack)
 **/
@RestController
@RequestMapping("/sys/post")
public class SysPostController extends AbstractController {

    @Autowired
    private SysPostService sysPostService;


    //分页列表模糊查询
    @RequestMapping("/list")
    @RequiresPermissions("sys:post:list")
    public BaseResponse list(@RequestParam Map<String,Object> paramMap){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            PageUtil page=sysPostService.queryPage(paramMap);
            resMap.put("page",page);

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        response.setData(resMap);
        return response;
    }

    //新增
    @LogAnnotation("新增岗位")
    @RequestMapping(value = "/save",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("sys:post:save")
    public BaseResponse save(@RequestBody @Validated SysPostEntity entity, BindingResult result){
        String res= ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(res)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),res);
        }

        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            log.info("新增岗位~接收到数据：{}",entity);

            sysPostService.savePost(entity);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;

    }


    //详情
    @RequestMapping(value = "/info/{id}")
    @RequiresPermissions("sys:post:info")
    public BaseResponse info(@PathVariable Long id){
        if (id==null || id<=0){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            log.info("岗位详情~接收到数据：{}",id);

            resMap.put("post",sysPostService.getById(id));

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        response.setData(resMap);
        return response;

    }

    //修改
    @LogAnnotation("修改岗位")
    @RequestMapping(value = "/update",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("sys:post:update")
    public BaseResponse update(@RequestBody @Validated SysPostEntity entity, BindingResult result){
        String res= ValidatorUtil.checkResult(result);
        if (StringUtils.isNotBlank(res)){
            return new BaseResponse(StatusCode.InvalidParams.getCode(),res);
        }
        if (entity.getPostId()==null || entity.getPostId()<=0){
            return new BaseResponse(StatusCode.InvalidParams);
        }

        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            log.info("修改岗位~接收到数据：{}",entity);

            sysPostService.updatePost(entity);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }

        return response;
    }


    //删除
    @LogAnnotation("删除岗位")
    @RequestMapping(value = "/delete",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("sys:post:delete")
    public BaseResponse delete(@RequestBody Long[] ids){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            log.info("删除岗位~接收到数据：{}", Arrays.asList(ids));

            sysPostService.deletePatch(ids);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }

        return response;
    }

    //岗位列表-select
    @RequestMapping("/select")
    public BaseResponse select(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            log.info("岗位列表~select..");

            Map<String,Object> resMap= Maps.newHashMap();
            resMap.put("list",sysPostService.list());

            response.setData(resMap);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}































