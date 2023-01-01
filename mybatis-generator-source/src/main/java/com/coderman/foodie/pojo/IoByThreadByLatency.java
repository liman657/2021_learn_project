package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class IoByThreadByLatency implements Serializable {
    private String user;

    private BigDecimal total;

    private String totalLatency;

    private String minLatency;

    private String avgLatency;

    private String maxLatency;

    private Long threadId;

    private Long processlistId;

    private static final long serialVersionUID = 1L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(String totalLatency) {
        this.totalLatency = totalLatency == null ? null : totalLatency.trim();
    }

    public String getMinLatency() {
        return minLatency;
    }

    public void setMinLatency(String minLatency) {
        this.minLatency = minLatency == null ? null : minLatency.trim();
    }

    public String getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(String avgLatency) {
        this.avgLatency = avgLatency == null ? null : avgLatency.trim();
    }

    public String getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(String maxLatency) {
        this.maxLatency = maxLatency == null ? null : maxLatency.trim();
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public Long getProcesslistId() {
        return processlistId;
    }

    public void setProcesslistId(Long processlistId) {
        this.processlistId = processlistId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user=").append(user);
        sb.append(", total=").append(total);
        sb.append(", totalLatency=").append(totalLatency);
        sb.append(", minLatency=").append(minLatency);
        sb.append(", avgLatency=").append(avgLatency);
        sb.append(", maxLatency=").append(maxLatency);
        sb.append(", threadId=").append(threadId);
        sb.append(", processlistId=").append(processlistId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}