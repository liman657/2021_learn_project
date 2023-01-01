package com.coderman.foodie.pojo;

import java.io.Serializable;

public class DefaultRoles implements Serializable {
    private String host;

    private String user;

    private String defaultRoleHost;

    private String defaultRoleUser;

    private static final long serialVersionUID = 1L;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getDefaultRoleHost() {
        return defaultRoleHost;
    }

    public void setDefaultRoleHost(String defaultRoleHost) {
        this.defaultRoleHost = defaultRoleHost == null ? null : defaultRoleHost.trim();
    }

    public String getDefaultRoleUser() {
        return defaultRoleUser;
    }

    public void setDefaultRoleUser(String defaultRoleUser) {
        this.defaultRoleUser = defaultRoleUser == null ? null : defaultRoleUser.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", host=").append(host);
        sb.append(", user=").append(user);
        sb.append(", defaultRoleHost=").append(defaultRoleHost);
        sb.append(", defaultRoleUser=").append(defaultRoleUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}