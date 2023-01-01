package com.coderman.foodie.pojo;

import java.io.Serializable;

public class ReplicationAsynchronousConnectionFailover implements Serializable {
    private String channelName;

    private String host;

    private Integer port;

    private String networkNamespace;

    private String managedName;

    private Byte weight;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getNetworkNamespace() {
        return networkNamespace;
    }

    public void setNetworkNamespace(String networkNamespace) {
        this.networkNamespace = networkNamespace == null ? null : networkNamespace.trim();
    }

    public String getManagedName() {
        return managedName;
    }

    public void setManagedName(String managedName) {
        this.managedName = managedName == null ? null : managedName.trim();
    }

    public Byte getWeight() {
        return weight;
    }

    public void setWeight(Byte weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", host=").append(host);
        sb.append(", port=").append(port);
        sb.append(", networkNamespace=").append(networkNamespace);
        sb.append(", managedName=").append(managedName);
        sb.append(", weight=").append(weight);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}