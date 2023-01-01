package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XUserSummary implements Serializable {
    private String user;

    private BigDecimal statements;

    private BigDecimal statementLatency;

    private BigDecimal statementAvgLatency;

    private BigDecimal tableScans;

    private BigDecimal fileIos;

    private BigDecimal fileIoLatency;

    private BigDecimal currentConnections;

    private BigDecimal totalConnections;

    private Long uniqueHosts;

    private BigDecimal currentMemory;

    private BigDecimal totalMemoryAllocated;

    private static final long serialVersionUID = 1L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public BigDecimal getStatements() {
        return statements;
    }

    public void setStatements(BigDecimal statements) {
        this.statements = statements;
    }

    public BigDecimal getStatementLatency() {
        return statementLatency;
    }

    public void setStatementLatency(BigDecimal statementLatency) {
        this.statementLatency = statementLatency;
    }

    public BigDecimal getStatementAvgLatency() {
        return statementAvgLatency;
    }

    public void setStatementAvgLatency(BigDecimal statementAvgLatency) {
        this.statementAvgLatency = statementAvgLatency;
    }

    public BigDecimal getTableScans() {
        return tableScans;
    }

    public void setTableScans(BigDecimal tableScans) {
        this.tableScans = tableScans;
    }

    public BigDecimal getFileIos() {
        return fileIos;
    }

    public void setFileIos(BigDecimal fileIos) {
        this.fileIos = fileIos;
    }

    public BigDecimal getFileIoLatency() {
        return fileIoLatency;
    }

    public void setFileIoLatency(BigDecimal fileIoLatency) {
        this.fileIoLatency = fileIoLatency;
    }

    public BigDecimal getCurrentConnections() {
        return currentConnections;
    }

    public void setCurrentConnections(BigDecimal currentConnections) {
        this.currentConnections = currentConnections;
    }

    public BigDecimal getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections(BigDecimal totalConnections) {
        this.totalConnections = totalConnections;
    }

    public Long getUniqueHosts() {
        return uniqueHosts;
    }

    public void setUniqueHosts(Long uniqueHosts) {
        this.uniqueHosts = uniqueHosts;
    }

    public BigDecimal getCurrentMemory() {
        return currentMemory;
    }

    public void setCurrentMemory(BigDecimal currentMemory) {
        this.currentMemory = currentMemory;
    }

    public BigDecimal getTotalMemoryAllocated() {
        return totalMemoryAllocated;
    }

    public void setTotalMemoryAllocated(BigDecimal totalMemoryAllocated) {
        this.totalMemoryAllocated = totalMemoryAllocated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user=").append(user);
        sb.append(", statements=").append(statements);
        sb.append(", statementLatency=").append(statementLatency);
        sb.append(", statementAvgLatency=").append(statementAvgLatency);
        sb.append(", tableScans=").append(tableScans);
        sb.append(", fileIos=").append(fileIos);
        sb.append(", fileIoLatency=").append(fileIoLatency);
        sb.append(", currentConnections=").append(currentConnections);
        sb.append(", totalConnections=").append(totalConnections);
        sb.append(", uniqueHosts=").append(uniqueHosts);
        sb.append(", currentMemory=").append(currentMemory);
        sb.append(", totalMemoryAllocated=").append(totalMemoryAllocated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}