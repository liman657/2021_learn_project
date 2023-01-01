package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XWaitClassesGlobalByLatency implements Serializable {
    private String eventClass;

    private BigDecimal total;

    private BigDecimal totalLatency;

    private Long minLatency;

    private BigDecimal avgLatency;

    private Long maxLatency;

    private static final long serialVersionUID = 1L;

    public String getEventClass() {
        return eventClass;
    }

    public void setEventClass(String eventClass) {
        this.eventClass = eventClass == null ? null : eventClass.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(BigDecimal totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Long getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(Long minLatency) {
        this.minLatency = minLatency;
    }

    public BigDecimal getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(BigDecimal avgLatency) {
        this.avgLatency = avgLatency;
    }

    public Long getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Long maxLatency) {
        this.maxLatency = maxLatency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventClass=").append(eventClass);
        sb.append(", total=").append(total);
        sb.append(", totalLatency=").append(totalLatency);
        sb.append(", minLatency=").append(minLatency);
        sb.append(", avgLatency=").append(avgLatency);
        sb.append(", maxLatency=").append(maxLatency);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}