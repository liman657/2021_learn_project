package com.learn.simpleblog.controller.admin;

import com.learn.simpleblog.annotation.LogAnnotation;
import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.controller.AbstractController;
import com.google.common.collect.Maps;
import com.learn.simpleblog.service.blog.IBlogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 微博管理
 * @Author:debug (SteadyJack)
 **/
@RestController
@RequestMapping("sys/blog")
public class BlogController extends AbstractController{

    @Autowired
    private IBlogService blogService;

    //分页模糊查询
    @RequestMapping("/list")
    public BaseResponse list(@RequestParam Map<String,Object> paramMap){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            log.info("微博管理~分页列表模糊查询：{}",paramMap);

            PageUtil page=blogService.queryPageAdmin(paramMap);
            resMap.put("page",page);

        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        response.setData(resMap);
        return response;
    }

    //删除-批量
    @LogAnnotation("删除微博")
    @RequestMapping(value = "/delete",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequiresPermissions("blog:info:delete")
    public BaseResponse delete(@RequestBody Integer[] ids){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            log.info("删除博客~接收到数据：{}", Arrays.asList(ids));

            blogService.deleteEntity(Arrays.asList(ids));
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }

        return response;
    }

    //屏蔽/恢复-批量
    @LogAnnotation("屏蔽/恢复微博")
    @PostMapping("active/unActive")
    @RequiresPermissions("blog:info:delete")
    public BaseResponse active(@RequestBody Integer[] ids){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            log.info("屏蔽/恢复微博博客~接收到数据：{}", Arrays.asList(ids));

            blogService.activeEntity(Arrays.asList(ids));
        }catch (Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }

        return response;
    }
}
































