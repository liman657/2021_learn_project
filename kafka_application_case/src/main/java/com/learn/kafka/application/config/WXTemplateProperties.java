package com.learn.kafka.application.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * autor:liman
 * createtime:2021/3/8
 * comment:针对答题模板的配置
 */
@Configuration
@ConfigurationProperties(prefix = "wxtemplate")
@Data
public class WXTemplateProperties {

    private List<WXTemplate> templates;
    private int templateResultType;
    private String templateResultFilePath;


    @Data
    public static class WXTemplate{
        private String templateId;
        private String templateFilePath;
        private boolean active;
    }

}
