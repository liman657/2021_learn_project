package com.coderman.foodie.pojo;

import java.io.Serializable;

public class GlobalGrants implements Serializable {
    private String user;

    private String host;

    private String priv;

    private String withGrantOption;

    private static final long serialVersionUID = 1L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getPriv() {
        return priv;
    }

    public void setPriv(String priv) {
        this.priv = priv == null ? null : priv.trim();
    }

    public String getWithGrantOption() {
        return withGrantOption;
    }

    public void setWithGrantOption(String withGrantOption) {
        this.withGrantOption = withGrantOption == null ? null : withGrantOption.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user=").append(user);
        sb.append(", host=").append(host);
        sb.append(", priv=").append(priv);
        sb.append(", withGrantOption=").append(withGrantOption);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}