package com.coderman.foodie.pojo;

import java.io.Serializable;

public class XSchemaTablesWithFullTableScans implements Serializable {
    private String objectSchema;

    private String objectName;

    private Long rowsFullScanned;

    private Long latency;

    private static final long serialVersionUID = 1L;

    public String getObjectSchema() {
        return objectSchema;
    }

    public void setObjectSchema(String objectSchema) {
        this.objectSchema = objectSchema == null ? null : objectSchema.trim();
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
    }

    public Long getRowsFullScanned() {
        return rowsFullScanned;
    }

    public void setRowsFullScanned(Long rowsFullScanned) {
        this.rowsFullScanned = rowsFullScanned;
    }

    public Long getLatency() {
        return latency;
    }

    public void setLatency(Long latency) {
        this.latency = latency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", objectSchema=").append(objectSchema);
        sb.append(", objectName=").append(objectName);
        sb.append(", rowsFullScanned=").append(rowsFullScanned);
        sb.append(", latency=").append(latency);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}