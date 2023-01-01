package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XUserSummaryByStatementLatency implements Serializable {
    private String user;

    private BigDecimal total;

    private BigDecimal totalLatency;

    private BigDecimal maxLatency;

    private BigDecimal lockLatency;

    private BigDecimal rowsSent;

    private BigDecimal rowsExamined;

    private BigDecimal rowsAffected;

    private BigDecimal fullScans;

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

    public BigDecimal getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(BigDecimal totalLatency) {
        this.totalLatency = totalLatency;
    }

    public BigDecimal getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(BigDecimal maxLatency) {
        this.maxLatency = maxLatency;
    }

    public BigDecimal getLockLatency() {
        return lockLatency;
    }

    public void setLockLatency(BigDecimal lockLatency) {
        this.lockLatency = lockLatency;
    }

    public BigDecimal getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(BigDecimal rowsSent) {
        this.rowsSent = rowsSent;
    }

    public BigDecimal getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(BigDecimal rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public BigDecimal getRowsAffected() {
        return rowsAffected;
    }

    public void setRowsAffected(BigDecimal rowsAffected) {
        this.rowsAffected = rowsAffected;
    }

    public BigDecimal getFullScans() {
        return fullScans;
    }

    public void setFullScans(BigDecimal fullScans) {
        this.fullScans = fullScans;
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
        sb.append(", maxLatency=").append(maxLatency);
        sb.append(", lockLatency=").append(lockLatency);
        sb.append(", rowsSent=").append(rowsSent);
        sb.append(", rowsExamined=").append(rowsExamined);
        sb.append(", rowsAffected=").append(rowsAffected);
        sb.append(", fullScans=").append(fullScans);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}