package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserSummary implements Serializable {
    private String user;

    private BigDecimal statements;

    private String statementLatency;

    private String statementAvgLatency;

    private BigDecimal tableScans;

    private BigDecimal fileIos;

    private String fileIoLatency;

    private BigDecimal currentConnections;

    private BigDecimal totalConnections;

    private Long uniqueHosts;

    private String currentMemory;

    private String totalMemoryAllocated;

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

    public String getStatementLatency() {
        return statementLatency;
    }

    public void setStatementLatency(String statementLatency) {
        this.statementLatency = statementLatency == null ? null : statementLatency.trim();
    }

    public String getStatementAvgLatency() {
        return statementAvgLatency;
    }

    public void setStatementAvgLatency(String statementAvgLatency) {
        this.statementAvgLatency = statementAvgLatency == null ? null : statementAvgLatency.trim();
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

    public String getFileIoLatency() {
        return fileIoLatency;
    }

    public void setFileIoLatency(String fileIoLatency) {
        this.fileIoLatency = fileIoLatency == null ? null : fileIoLatency.trim();
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

    public String getCurrentMemory() {
        return currentMemory;
    }

    public void setCurrentMemory(String currentMemory) {
        this.currentMemory = currentMemory == null ? null : currentMemory.trim();
    }

    public String getTotalMemoryAllocated() {
        return totalMemoryAllocated;
    }

    public void setTotalMemoryAllocated(String totalMemoryAllocated) {
        this.totalMemoryAllocated = totalMemoryAllocated == null ? null : totalMemoryAllocated.trim();
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