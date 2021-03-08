package com.learn.kafka.application.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.learn.kafka.application.config.WXTemplateProperties;
import com.learn.kafka.application.config.WXTemplateProperties.WXTemplate;
import com.learn.kafka.application.service.IWXTemplateService;
import com.learn.kafka.application.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * autor:liman
 * createtime:2021/3/8
 * comment:
 */
@Service
@Slf4j
public class WXTemplateServiceImpl implements IWXTemplateService {

    @Autowired
    private WXTemplateProperties templateProperties;

    @Override
    public WXTemplateProperties.WXTemplate getWXAnswerTemplate() {

        List<WXTemplate> templates = templateProperties.getTemplates();
        Optional<WXTemplate> firstTemplateResult = templates.stream().filter((template) -> template.isActive()).findFirst();
        return firstTemplateResult.isPresent() ? firstTemplateResult.get() : null;
    }

    @Override
    public void templateAnswerReport(JSONObject reportInfo) {
        log.info("开始上报问卷统计结果:{[这里是测试]}");
    }

    @Override
    public JSONObject getAnswerStatistics(String templateId) {

        //判断数据结果获取类型
        if(templateProperties.getTemplateResultType() == 0){//文件获取
            return FileUtils.readFile2JsonObject(templateProperties.getTemplateResultFilePath()).get();
        }else{

        }

        return null;
    }
}
