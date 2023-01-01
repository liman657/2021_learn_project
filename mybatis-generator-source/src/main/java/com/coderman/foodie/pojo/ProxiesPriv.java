package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProxiesPriv implements Serializable {
    private String host;

    private String user;

    private String proxiedHost;

    private String proxiedUser;

    private Boolean withGrant;

    private String grantor;

    private Date timestamp;

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

    public String getProxiedHost() {
        return proxiedHost;
    }

    public void setProxiedHost(String proxiedHost) {
        this.proxiedHost = proxiedHost == null ? null : proxiedHost.trim();
    }

    public String getProxiedUser() {
        return proxiedUser;
    }

    public void setProxiedUser(String proxiedUser) {
        this.proxiedUser = proxiedUser == null ? null : proxiedUser.trim();
    }

    public Boolean getWithGrant() {
        return withGrant;
    }

    public void setWithGrant(Boolean withGrant) {
        this.withGrant = withGrant;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor == null ? null : grantor.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", host=").append(host);
        sb.append(", user=").append(user);
        sb.append(", proxiedHost=").append(proxiedHost);
        sb.append(", proxiedUser=").append(proxiedUser);
        sb.append(", withGrant=").append(withGrant);
        sb.append(", grantor=").append(grantor);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}