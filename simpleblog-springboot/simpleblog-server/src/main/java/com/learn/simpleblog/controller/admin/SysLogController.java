package com.learn.simpleblog.controller.admin;

import com.google.common.collect.Maps;
import com.learn.simpleblog.api.response.BaseResponse;
import com.learn.simpleblog.api.response.StatusCode;
import com.learn.simpleblog.api.utils.PageUtil;
import com.learn.simpleblog.controller.AbstractController;
import com.learn.simpleblog.service.pmp.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


//系统日志
@Controller
@RequestMapping("/sys/log")
public class SysLogController extends AbstractController {

	@Autowired
	private SysLogService sysLogService;
	
	//列表
	@ResponseBody
	@RequestMapping("/list")
	public BaseResponse list(@RequestParam Map<String, Object> params){
		BaseResponse response=new BaseResponse(StatusCode.Success);
		Map<String,Object> resMap= Maps.newHashMap();
		try {
			log.info("日志模块-列表查询");

			PageUtil page = sysLogService.queryPage(params);
			resMap.put("page", page);

			response.setData(resMap);
		}catch (Exception e){
			response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
		}
		return response;
	}

	//清除
	@ResponseBody
	@RequestMapping("/truncate")
	@RequiresPermissions("sys:log:truncate")
	public BaseResponse truncate(){
		BaseResponse response=new BaseResponse(StatusCode.Success);
		try {
			sysLogService.truncate();

		}catch (Exception e){
			response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
		}
		return response;
	}

}
