package com.learn.demo.security.core.config;

import com.learn.demo.security.core.properties.SecurityProperties;
import org.springframework.boot.actuate.autoconfigure.ConditionalOnEnabledInfoContributor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * autor:liman
 * createtime:2021/5/13
 * comment:
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
