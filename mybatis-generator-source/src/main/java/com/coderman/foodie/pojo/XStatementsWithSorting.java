package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class XStatementsWithSorting implements Serializable {
    private String db;

    private Long execCount;

    private Long totalLatency;

    private Long sortMergePasses;

    private BigDecimal avgSortMerges;

    private Long sortsUsingScans;

    private Long sortUsingRange;

    private Long rowsSorted;

    private BigDecimal avgRowsSorted;

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

    public Long getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Long totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Long getSortMergePasses() {
        return sortMergePasses;
    }

    public void setSortMergePasses(Long sortMergePasses) {
        this.sortMergePasses = sortMergePasses;
    }

    public BigDecimal getAvgSortMerges() {
        return avgSortMerges;
    }

    public void setAvgSortMerges(BigDecimal avgSortMerges) {
        this.avgSortMerges = avgSortMerges;
    }

    public Long getSortsUsingScans() {
        return sortsUsingScans;
    }

    public void setSortsUsingScans(Long sortsUsingScans) {
        this.sortsUsingScans = sortsUsingScans;
    }

    public Long getSortUsingRange() {
        return sortUsingRange;
    }

    public void setSortUsingRange(Long sortUsingRange) {
        this.sortUsingRange = sortUsingRange;
    }

    public Long getRowsSorted() {
        return rowsSorted;
    }

    public void setRowsSorted(Long rowsSorted) {
        this.rowsSorted = rowsSorted;
    }

    public BigDecimal getAvgRowsSorted() {
        return avgRowsSorted;
    }

    public void setAvgRowsSorted(BigDecimal avgRowsSorted) {
        this.avgRowsSorted = avgRowsSorted;
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
        sb.append(", sortMergePasses=").append(sortMergePasses);
        sb.append(", avgSortMerges=").append(avgSortMerges);
        sb.append(", sortsUsingScans=").append(sortsUsingScans);
        sb.append(", sortUsingRange=").append(sortUsingRange);
        sb.append(", rowsSorted=").append(rowsSorted);
        sb.append(", avgRowsSorted=").append(avgRowsSorted);
        sb.append(", firstSeen=").append(firstSeen);
        sb.append(", lastSeen=").append(lastSeen);
        sb.append(", digest=").append(digest);
        sb.append(", query=").append(query);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}