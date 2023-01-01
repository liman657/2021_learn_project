package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class InnodbTableStats implements Serializable {
    private String databaseName;

    private String tableName;

    private Date lastUpdate;

    private Long nRows;

    private Long clusteredIndexSize;

    private Long sumOfOtherIndexSizes;

    private static final long serialVersionUID = 1L;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName == null ? null : databaseName.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getnRows() {
        return nRows;
    }

    public void setnRows(Long nRows) {
        this.nRows = nRows;
    }

    public Long getClusteredIndexSize() {
        return clusteredIndexSize;
    }

    public void setClusteredIndexSize(Long clusteredIndexSize) {
        this.clusteredIndexSize = clusteredIndexSize;
    }

    public Long getSumOfOtherIndexSizes() {
        return sumOfOtherIndexSizes;
    }

    public void setSumOfOtherIndexSizes(Long sumOfOtherIndexSizes) {
        this.sumOfOtherIndexSizes = sumOfOtherIndexSizes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", databaseName=").append(databaseName);
        sb.append(", tableName=").append(tableName);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", nRows=").append(nRows);
        sb.append(", clusteredIndexSize=").append(clusteredIndexSize);
        sb.append(", sumOfOtherIndexSizes=").append(sumOfOtherIndexSizes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}