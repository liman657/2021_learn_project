package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StatementsWithFullTableScans implements Serializable {
    private String db;

    private Long execCount;

    private String totalLatency;

    private Long noIndexUsedCount;

    private Long noGoodIndexUsedCount;

    private BigDecimal noIndexUsedPct;

    private Long rowsSent;

    private Long rowsExamined;

    private BigDecimal rowsSentAvg;

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

    public Long getExecCount() {
        return execCount;
    }

    public void setExecCount(Long execCount) {
        this.execCount = execCount;
    }

    public String getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(String totalLatency) {
        this.totalLatency = totalLatency == null ? null : totalLatency.trim();
    }

    public Long getNoIndexUsedCount() {
        return noIndexUsedCount;
    }

    public void setNoIndexUsedCount(Long noIndexUsedCount) {
        this.noIndexUsedCount = noIndexUsedCount;
    }

    public Long getNoGoodIndexUsedCount() {
        return noGoodIndexUsedCount;
    }

    public void setNoGoodIndexUsedCount(Long noGoodIndexUsedCount) {
        this.noGoodIndexUsedCount = noGoodIndexUsedCount;
    }

    public BigDecimal getNoIndexUsedPct() {
        return noIndexUsedPct;
    }

    public void setNoIndexUsedPct(BigDecimal noIndexUsedPct) {
        this.noIndexUsedPct = noIndexUsedPct;
    }

    public Long getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Long rowsSent) {
        this.rowsSent = rowsSent;
    }

    public Long getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Long rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public BigDecimal getRowsSentAvg() {
        return rowsSentAvg;
    }

    public void setRowsSentAvg(BigDecimal rowsSentAvg) {
        this.rowsSentAvg = rowsSentAvg;
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
        sb.append(", execCount=").append(execCount);
        sb.append(", totalLatency=").append(totalLatency);
        sb.append(", noIndexUsedCount=").append(noIndexUsedCount);
        sb.append(", noGoodIndexUsedCount=").append(noGoodIndexUsedCount);
        sb.append(", noIndexUsedPct=").append(noIndexUsedPct);
        sb.append(", rowsSent=").append(rowsSent);
        sb.append(", rowsExamined=").append(rowsExamined);
        sb.append(", rowsSentAvg=").append(rowsSentAvg);
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