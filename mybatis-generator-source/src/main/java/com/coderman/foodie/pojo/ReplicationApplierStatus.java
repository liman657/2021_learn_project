package com.coderman.foodie.pojo;

import java.io.Serializable;

public class ReplicationApplierStatus implements Serializable {
    private String channelName;

    private String serviceState;

    private Integer remainingDelay;

    private Long countTransactionsRetries;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState == null ? null : serviceState.trim();
    }

    public Integer getRemainingDelay() {
        return remainingDelay;
    }

    public void setRemainingDelay(Integer remainingDelay) {
        this.remainingDelay = remainingDelay;
    }

    public Long getCountTransactionsRetries() {
        return countTransactionsRetries;
    }

    public void setCountTransactionsRetries(Long countTransactionsRetries) {
        this.countTransactionsRetries = countTransactionsRetries;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", serviceState=").append(serviceState);
        sb.append(", remainingDelay=").append(remainingDelay);
        sb.append(", countTransactionsRetries=").append(countTransactionsRetries);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}