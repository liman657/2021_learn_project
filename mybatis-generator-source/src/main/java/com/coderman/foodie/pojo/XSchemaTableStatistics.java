package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class XSchemaTableStatistics implements Serializable {
    private String tableSchema;

    private String tableName;

    private Long totalLatency;

    private Long rowsFetched;

    private Long fetchLatency;

    private Long rowsInserted;

    private Long insertLatency;

    private Long rowsUpdated;

    private Long updateLatency;

    private Long rowsDeleted;

    private Long deleteLatency;

    private BigDecimal ioReadRequests;

    private BigDecimal ioRead;

    private BigDecimal ioReadLatency;

    private BigDecimal ioWriteRequests;

    private BigDecimal ioWrite;

    private BigDecimal ioWriteLatency;

    private BigDecimal ioMiscRequests;

    private BigDecimal ioMiscLatency;

    private static final long serialVersionUID = 1L;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema == null ? null : tableSchema.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Long getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(Long totalLatency) {
        this.totalLatency = totalLatency;
    }

    public Long getRowsFetched() {
        return rowsFetched;
    }

    public void setRowsFetched(Long rowsFetched) {
        this.rowsFetched = rowsFetched;
    }

    public Long getFetchLatency() {
        return fetchLatency;
    }

    public void setFetchLatency(Long fetchLatency) {
        this.fetchLatency = fetchLatency;
    }

    public Long getRowsInserted() {
        return rowsInserted;
    }

    public void setRowsInserted(Long rowsInserted) {
        this.rowsInserted = rowsInserted;
    }

    public Long getInsertLatency() {
        return insertLatency;
    }

    public void setInsertLatency(Long insertLatency) {
        this.insertLatency = insertLatency;
    }

    public Long getRowsUpdated() {
        return rowsUpdated;
    }

    public void setRowsUpdated(Long rowsUpdated) {
        this.rowsUpdated = rowsUpdated;
    }

    public Long getUpdateLatency() {
        return updateLatency;
    }

    public void setUpdateLatency(Long updateLatency) {
        this.updateLatency = updateLatency;
    }

    public Long getRowsDeleted() {
        return rowsDeleted;
    }

    public void setRowsDeleted(Long rowsDeleted) {
        this.rowsDeleted = rowsDeleted;
    }

    public Long getDeleteLatency() {
        return deleteLatency;
    }

    public void setDeleteLatency(Long deleteLatency) {
        this.deleteLatency = deleteLatency;
    }

    public BigDecimal getIoReadRequests() {
        return ioReadRequests;
    }

    public void setIoReadRequests(BigDecimal ioReadRequests) {
        this.ioReadRequests = ioReadRequests;
    }

    public BigDecimal getIoRead() {
        return ioRead;
    }

    public void setIoRead(BigDecimal ioRead) {
        this.ioRead = ioRead;
    }

    public BigDecimal getIoReadLatency() {
        return ioReadLatency;
    }

    public void setIoReadLatency(BigDecimal ioReadLatency) {
        this.ioReadLatency = ioReadLatency;
    }

    public BigDecimal getIoWriteRequests() {
        return ioWriteRequests;
    }

    public void setIoWriteRequests(BigDecimal ioWriteRequests) {
        this.ioWriteRequests = ioWriteRequests;
    }

    public BigDecimal getIoWrite() {
        return ioWrite;
    }

    public void setIoWrite(BigDecimal ioWrite) {
        this.ioWrite = ioWrite;
    }

    public BigDecimal getIoWriteLatency() {
        return ioWriteLatency;
    }

    public void setIoWriteLatency(BigDecimal ioWriteLatency) {
        this.ioWriteLatency = ioWriteLatency;
    }

    public BigDecimal getIoMiscRequests() {
        return ioMiscRequests;
    }

    public void setIoMiscRequests(BigDecimal ioMiscRequests) {
        this.ioMiscRequests = ioMiscRequests;
    }

    public BigDecimal getIoMiscLatency() {
        return ioMiscLatency;
    }

    public void setIoMiscLatency(BigDecimal ioMiscLatency) {
        this.ioMiscLatency = ioMiscLatency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableSchema=").append(tableSchema);
        sb.append(", tableName=").append(tableName);
        sb.append(", totalLatency=").append(totalLatency);
        sb.append(", rowsFetched=").append(rowsFetched);
        sb.append(", fetchLatency=").append(fetchLatency);
        sb.append(", rowsInserted=").append(rowsInserted);
        sb.append(", insertLatency=").append(insertLatency);
        sb.append(", rowsUpdated=").append(rowsUpdated);
        sb.append(", updateLatency=").append(updateLatency);
        sb.append(", rowsDeleted=").append(rowsDeleted);
        sb.append(", deleteLatency=").append(deleteLatency);
        sb.append(", ioReadRequests=").append(ioReadRequests);
        sb.append(", ioRead=").append(ioRead);
        sb.append(", ioReadLatency=").append(ioReadLatency);
        sb.append(", ioWriteRequests=").append(ioWriteRequests);
        sb.append(", ioWrite=").append(ioWrite);
        sb.append(", ioWriteLatency=").append(ioWriteLatency);
        sb.append(", ioMiscRequests=").append(ioMiscRequests);
        sb.append(", ioMiscLatency=").append(ioMiscLatency);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}