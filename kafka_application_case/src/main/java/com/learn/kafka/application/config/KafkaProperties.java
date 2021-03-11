package com.learn.kafka.application.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * autor:liman
 * createtime:2021/3/9
 * comment:
 */
@ConfigurationProperties(prefix = "")
@Configuration
@Data
public class KafkaProperties {

    private String bootstrapServers;
    private String acksConfig;
    private String partitionerClass;

}
