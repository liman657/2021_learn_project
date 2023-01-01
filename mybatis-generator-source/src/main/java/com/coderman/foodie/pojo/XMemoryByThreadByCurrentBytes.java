package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XMemoryByThreadByCurrentBytes implements Serializable {
    private Long threadId;

    private String user;

    private BigDecimal currentCountUsed;

    private BigDecimal currentAllocated;

    private BigDecimal currentAvgAlloc;

    private Long currentMaxAlloc;

    private BigDecimal totalAllocated;

    private static final long serialVersionUID = 1L;

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public BigDecimal getCurrentCountUsed() {
        return currentCountUsed;
    }

    public void setCurrentCountUsed(BigDecimal currentCountUsed) {
        this.currentCountUsed = currentCountUsed;
    }

    public BigDecimal getCurrentAllocated() {
        return currentAllocated;
    }

    public void setCurrentAllocated(BigDecimal currentAllocated) {
        this.currentAllocated = currentAllocated;
    }

    public BigDecimal getCurrentAvgAlloc() {
        return currentAvgAlloc;
    }

    public void setCurrentAvgAlloc(BigDecimal currentAvgAlloc) {
        this.currentAvgAlloc = currentAvgAlloc;
    }

    public Long getCurrentMaxAlloc() {
        return currentMaxAlloc;
    }

    public void setCurrentMaxAlloc(Long currentMaxAlloc) {
        this.currentMaxAlloc = currentMaxAlloc;
    }

    public BigDecimal getTotalAllocated() {
        return totalAllocated;
    }

    public void setTotalAllocated(BigDecimal totalAllocated) {
        this.totalAllocated = totalAllocated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", threadId=").append(threadId);
        sb.append(", user=").append(user);
        sb.append(", currentCountUsed=").append(currentCountUsed);
        sb.append(", currentAllocated=").append(currentAllocated);
        sb.append(", currentAvgAlloc=").append(currentAvgAlloc);
        sb.append(", currentMaxAlloc=").append(currentMaxAlloc);
        sb.append(", totalAllocated=").append(totalAllocated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}