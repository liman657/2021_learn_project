package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XMemoryGlobalByCurrentBytes implements Serializable {
    private String eventName;

    private Long currentCount;

    private Long currentAlloc;

    private BigDecimal currentAvgAlloc;

    private Long highCount;

    private Long highAlloc;

    private BigDecimal highAvgAlloc;

    private static final long serialVersionUID = 1L;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public Long getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Long currentCount) {
        this.currentCount = currentCount;
    }

    public Long getCurrentAlloc() {
        return currentAlloc;
    }

    public void setCurrentAlloc(Long currentAlloc) {
        this.currentAlloc = currentAlloc;
    }

    public BigDecimal getCurrentAvgAlloc() {
        return currentAvgAlloc;
    }

    public void setCurrentAvgAlloc(BigDecimal currentAvgAlloc) {
        this.currentAvgAlloc = currentAvgAlloc;
    }

    public Long getHighCount() {
        return highCount;
    }

    public void setHighCount(Long highCount) {
        this.highCount = highCount;
    }

    public Long getHighAlloc() {
        return highAlloc;
    }

    public void setHighAlloc(Long highAlloc) {
        this.highAlloc = highAlloc;
    }

    public BigDecimal getHighAvgAlloc() {
        return highAvgAlloc;
    }

    public void setHighAvgAlloc(BigDecimal highAvgAlloc) {
        this.highAvgAlloc = highAvgAlloc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventName=").append(eventName);
        sb.append(", currentCount=").append(currentCount);
        sb.append(", currentAlloc=").append(currentAlloc);
        sb.append(", currentAvgAlloc=").append(currentAvgAlloc);
        sb.append(", highCount=").append(highCount);
        sb.append(", highAlloc=").append(highAlloc);
        sb.append(", highAvgAlloc=").append(highAvgAlloc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}