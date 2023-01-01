package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ReplicationApplierGlobalFilters implements Serializable {
    private String filterName;

    private String configuredBy;

    private Date activeSince;

    private String filterRule;

    private static final long serialVersionUID = 1L;

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
        sb.append(", filterName=").append(filterName);
        sb.append(", configuredBy=").append(configuredBy);
        sb.append(", activeSince=").append(activeSince);
        sb.append(", filterRule=").append(filterRule);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}