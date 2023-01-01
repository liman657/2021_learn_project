package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class XStatementsWithRuntimesIn95thPercentile implements Serializable {
    private String db;

    private String fullScan;

    private Long execCount;

    private Long errCount;

    private Long warnCount;

    private Long totalLatency;

    private Long maxLatency;

    private Long avgLatency;

    private Long rowsSent;

    private BigDecimal rowsSentAvg;

    private Long rowsExamined;

    private BigDecimal rowsExaminedAvg;

    private Date firstSeen;

    private Date lastSeen;

    private String digest;

    private String query;

    private static final long serialVersionUID = 1L;

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public String getFullScan() {
        return fullScan;
    }

    public void setFullScan(String fullScan) {
        this.fullScan = fullScan == null ? null : fullScan.trim();
    }

    public Long getExecCount() {
        return execCount;
    }

    public void setExecCount(Long execCount) {
        this.execCount = execCount;
    }

    public Long getErrCount() {
        return errCount;
    }

    public void setErrCount(Long errCount) {
        this.errCount = errCount;
    }

    public Long getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(Long warnCount) {
        this.warnCount = warnCount;
    }

    public Long getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Long totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Long getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Long maxLatency) {
        this.maxLatency = maxLatency;
    }

    public Long getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(Long avgLatency) {
        this.avgLatency = avgLatency;
    }

    public Long getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Long rowsSent) {
        this.rowsSent = rowsSent;
    }

    public BigDecimal getRowsSentAvg() {
        return rowsSentAvg;
    }

    public void setRowsSentAvg(BigDecimal rowsSentAvg) {
        this.rowsSentAvg = rowsSentAvg;
    }

    public Long getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Long rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public BigDecimal getRowsExaminedAvg() {
        return rowsExaminedAvg;
    }

    public void setRowsExaminedAvg(BigDecimal rowsExaminedAvg) {
        this.rowsExaminedAvg = rowsExaminedAvg;
    }

    public Date getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query == null ? null : query.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", db=").append(db);
        sb.append(", fullScan=").append(fullScan);
        sb.append(", execCount=").append(execCount);
        sb.append(", errCount=").append(errCount);
        sb.append(", warnCount=").append(warnCount);
        sb.append(", totalLatency=").append(totalLatency);
        sb.append(", maxLatency=").append(maxLatency);
        sb.append(", avgLatency=").append(avgLatency);
        sb.append(", rowsSent=").append(rowsSent);
        sb.append(", rowsSentAvg=").append(rowsSentAvg);
        sb.append(", rowsExamined=").append(rowsExamined);
        sb.append(", rowsExaminedAvg=").append(rowsExaminedAvg);
        sb.append(", firstSeen=").append(firstSeen);
        sb.append(", lastSeen=").append(lastSeen);
        sb.append(", digest=").append(digest);
        sb.append(", query=").append(query);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}