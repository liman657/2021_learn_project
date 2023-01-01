package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MemoryByThreadByCurrentBytes implements Serializable {
    private Long threadId;

    private String user;

    private BigDecimal currentCountUsed;

    private String currentAllocated;

    private String currentAvgAlloc;

    private String currentMaxAlloc;

    private String totalAllocated;

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

    public String getCurrentAllocated() {
        return currentAllocated;
    }

    public void setCurrentAllocated(String currentAllocated) {
        this.currentAllocated = currentAllocated == null ? null : currentAllocated.trim();
    }

    public String getCurrentAvgAlloc() {
        return currentAvgAlloc;
    }

    public void setCurrentAvgAlloc(String currentAvgAlloc) {
        this.currentAvgAlloc = currentAvgAlloc == null ? null : currentAvgAlloc.trim();
    }

    public String getCurrentMaxAlloc() {
        return currentMaxAlloc;
    }

    public void setCurrentMaxAlloc(String currentMaxAlloc) {
        this.currentMaxAlloc = currentMaxAlloc == null ? null : currentMaxAlloc.trim();
    }

    public String getTotalAllocated() {
        return totalAllocated;
    }

    public void setTotalAllocated(String totalAllocated) {
        this.totalAllocated = totalAllocated == null ? null : totalAllocated.trim();
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