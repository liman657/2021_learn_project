package com.coderman.foodie.pojo;

import java.io.Serializable;

public class ReplicationAsynchronousConnectionFailoverManaged implements Serializable {
    private String channelName;

    private String managedName;

    private String managedType;

    private String configuration;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getManagedName() {
        return managedName;
    }

    public void setManagedName(String managedName) {
        this.managedName = managedName == null ? null : managedName.trim();
    }

    public String getManagedType() {
        return managedType;
    }

    public void setManagedType(String managedType) {
        this.managedType = managedType == null ? null : managedType.trim();
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration == null ? null : configuration.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", managedName=").append(managedName);
        sb.append(", managedType=").append(managedType);
        sb.append(", configuration=").append(configuration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}