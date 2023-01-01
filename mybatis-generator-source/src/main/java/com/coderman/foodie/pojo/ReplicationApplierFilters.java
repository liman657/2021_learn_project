package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ReplicationApplierFilters implements Serializable {
    private String channelName;

    private String filterName;

    private String configuredBy;

    private Date activeSince;

    private Long counter;

    private String filterRule;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName == null ? null : filterName.trim();
    }

    public String getConfiguredBy() {
        return configuredBy;
    }

    public void setConfiguredBy(String configuredBy) {
        this.configuredBy = configuredBy == null ? null : configuredBy.trim();
    }

    public Date getActiveSince() {
        return activeSince;
    }

    public void setActiveSince(Date activeSince) {
        this.activeSince = activeSince;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public String getFilterRule() {
        return filterRule;
    }

    public void setFilterRule(String filterRule) {
        this.filterRule = filterRule == null ? null : filterRule.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", filterName=").append(filterName);
        sb.append(", configuredBy=").append(configuredBy);
        sb.append(", activeSince=").append(activeSince);
        sb.append(", counter=").append(counter);
        sb.append(", filterRule=").append(filterRule);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}