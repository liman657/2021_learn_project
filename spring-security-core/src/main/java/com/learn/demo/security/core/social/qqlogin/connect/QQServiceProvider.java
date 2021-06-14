package com.learn.demo.security.core.social.qqlogin.connect;

import com.learn.demo.security.core.social.qqlogin.api.QQObtainUser;
import com.learn.demo.security.core.social.qqlogin.api.QQObtainUserImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * autor:liman
 * createtime:2021/5/30
 * comment:
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQObtainUser> {
    private String appId;

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";
    /**
     * Create a new {@link OAuth2ServiceProvider}.
     *
     * @param oauth2Operations the OAuth2Operations template for conducting the OAuth 2 flow with the provider.
     */
    public QQServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
    }

    @Override
    public QQObtainUser getApi(String accessToken) {
        return new QQObtainUserImpl(accessToken,appId);
    }
}
