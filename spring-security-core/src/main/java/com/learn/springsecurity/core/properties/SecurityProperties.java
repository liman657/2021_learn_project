package com.learn.springsecurity.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * autor:liman
 * createtime:2021/7/9
 * comment:
 */
@ConfigurationProperties(prefix = "self.security.core")
public class SecurityProperties {

    private BrowersProperties browser = new BrowersProperties();

    public BrowersProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowersProperties browser) {
        this.browser = browser;
    }
}
