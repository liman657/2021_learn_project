package com.learn.kafka.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.kafka.application.common.BaseResponseVO;
import com.learn.kafka.application.config.WXTemplateProperties;
import com.learn.kafka.application.service.IWXTemplateService;
import com.learn.kafka.application.service.impl.WXTemplateServiceImpl;
import com.learn.kafka.application.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.learn.kafka.application.config.WXTemplateProperties.WXTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * autor:liman
 * createtime:2021/3/8
 * comment:微信调查文件模板controller
 */
@RestController
@RequestMapping(value = "/wxtemplate")
@Slf4j
public class WXTemplateController {

    @Autowired
    private WXTemplateProperties wxTemplateProperties;
    @Autowired
    private IWXTemplateService wxTemplateService;

    @RequestMapping(value = "/template",method = RequestMethod.GET)
    public BaseResponseVO getTemplateList(){

        BaseResponseVO result = BaseResponseVO.success();
        Map<String,Object> data = new HashMap<>();
        WXTemplate wxAnswerTemplate = wxTemplateService.getWXAnswerTemplate();

        data.put("templateId",wxAnswerTemplate.getTemplateId());
        data.put("template", FileUtils.readFile2JsonArray(wxAnswerTemplate.getTemplateFilePath()));
        result.setResult(data);
        return result;
    }

    @RequestMapping(value = "/template/result",method = RequestMethod.GET)
    public BaseResponseVO getAnswerStatistic(@RequestParam(value="templateId",required = false) String templateId){
        BaseResponseVO result = BaseResponseVO.success();
        JSONObject answerStatistics = wxTemplateService.getAnswerStatistics(templateId);
        result.setResult(answerStatistics);
        return result;
    }

    @RequestMapping(value = "/template/report",method = RequestMethod.POST)
    public BaseResponseVO reportAnswer(@RequestBody String reportData){
        wxTemplateService.templateAnswerReport(JSONObject.parseObject(reportData));
        return BaseResponseVO.success();
    }

}
