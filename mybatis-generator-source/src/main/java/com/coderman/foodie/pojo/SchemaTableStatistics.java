package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SchemaTableStatistics implements Serializable {
    private String tableSchema;

    private String tableName;

    private String totalLatency;

    private Long rowsFetched;

    private String fetchLatency;

    private Long rowsInserted;

    private String insertLatency;

    private Long rowsUpdated;

    private String updateLatency;

    private Long rowsDeleted;

    private String deleteLatency;

    private BigDecimal ioReadRequests;

    private String ioRead;

    private String ioReadLatency;

    private BigDecimal ioWriteRequests;

    private String ioWrite;

    private String ioWriteLatency;

    private BigDecimal ioMiscRequests;

    private String ioMiscLatency;

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

    public String getTotalLatency() {
        return totalLatency;
    }

    public void setTotalLatency(String totalLatency) {
        this.totalLatency = totalLatency == null ? null : totalLatency.trim();
    }

    public Long getRowsFetched() {
        return rowsFetched;
    }

    public void setRowsFetched(Long rowsFetched) {
        this.rowsFetched = rowsFetched;
    }

    public String getFetchLatency() {
        return fetchLatency;
    }

    public void setFetchLatency(String fetchLatency) {
        this.fetchLatency = fetchLatency == null ? null : fetchLatency.trim();
    }

    public Long getRowsInserted() {
        return rowsInserted;
    }

    public void setRowsInserted(Long rowsInserted) {
        this.rowsInserted = rowsInserted;
    }

    public String getInsertLatency() {
        return insertLatency;
    }

    public void setInsertLatency(String insertLatency) {
        this.insertLatency = insertLatency == null ? null : insertLatency.trim();
    }

    public Long getRowsUpdated() {
        return rowsUpdated;
    }

    public void setRowsUpdated(Long rowsUpdated) {
        this.rowsUpdated = rowsUpdated;
    }

    public String getUpdateLatency() {
        return updateLatency;
    }

    public void setUpdateLatency(String updateLatency) {
        this.updateLatency = updateLatency == null ? null : updateLatency.trim();
    }

    public Long getRowsDeleted() {
        return rowsDeleted;
    }

    public void setRowsDeleted(Long rowsDeleted) {
        this.rowsDeleted = rowsDeleted;
    }

    public String getDeleteLatency() {
        return deleteLatency;
    }

    public void setDeleteLatency(String deleteLatency) {
        this.deleteLatency = deleteLatency == null ? null : deleteLatency.trim();
    }

    public BigDecimal getIoReadRequests() {
        return ioReadRequests;
    }

    public void setIoReadRequests(BigDecimal ioReadRequests) {
        this.ioReadRequests = ioReadRequests;
    }

    public String getIoRead() {
        return ioRead;
    }

    public void setIoRead(String ioRead) {
        this.ioRead = ioRead == null ? null : ioRead.trim();
    }

    public String getIoReadLatency() {
        return ioReadLatency;
    }

    public void setIoReadLatency(String ioReadLatency) {
        this.ioReadLatency = ioReadLatency == null ? null : ioReadLatency.trim();
    }

    public BigDecimal getIoWriteRequests() {
        return ioWriteRequests;
    }

    public void setIoWriteRequests(BigDecimal ioWriteRequests) {
        this.ioWriteRequests = ioWriteRequests;
    }

    public String getIoWrite() {
        return ioWrite;
    }

    public void setIoWrite(String ioWrite) {
        this.ioWrite = ioWrite == null ? null : ioWrite.trim();
    }

    public String getIoWriteLatency() {
        return ioWriteLatency;
    }

    public void setIoWriteLatency(String ioWriteLatency) {
        this.ioWriteLatency = ioWriteLatency == null ? null : ioWriteLatency.trim();
    }

    public BigDecimal getIoMiscRequests() {
        return ioMiscRequests;
    }

    public void setIoMiscRequests(BigDecimal ioMiscRequests) {
        this.ioMiscRequests = ioMiscRequests;
    }

    public String getIoMiscLatency() {
        return ioMiscLatency;
    }

    public void setIoMiscLatency(String ioMiscLatency) {
        this.ioMiscLatency = ioMiscLatency == null ? null : ioMiscLatency.trim();
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