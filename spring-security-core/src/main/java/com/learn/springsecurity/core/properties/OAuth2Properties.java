package com.learn.springsecurity.core.properties;

/**
 * autor:liman
 * createtime:2021/8/9
 * comment:
 */
public class OAuth2Properties {

    private OAuth2ClientProperties[] clients = {};

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }
}
