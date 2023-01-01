package com.coderman.foodie.pojo;

import java.io.Serializable;

public class XSchemaFlattenedKeys implements Serializable {
    private String tableSchema;

    private String tableName;

    private String indexName;

    private Integer nonUnique;

    private Long subpartExists;

    private String indexColumns;

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

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    public Integer getNonUnique() {
        return nonUnique;
    }

    public void setNonUnique(Integer nonUnique) {
        this.nonUnique = nonUnique;
    }

    public Long getSubpartExists() {
        return subpartExists;
    }

    public void setSubpartExists(Long subpartExists) {
        this.subpartExists = subpartExists;
    }

    public String getIndexColumns() {
        return indexColumns;
    }

    public void setIndexColumns(String indexColumns) {
        this.indexColumns = indexColumns == null ? null : indexColumns.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tableSchema=").append(tableSchema);
        sb.append(", tableName=").append(tableName);
        sb.append(", indexName=").append(indexName);
        sb.append(", nonUnique=").append(nonUnique);
        sb.append(", subpartExists=").append(subpartExists);
        sb.append(", indexColumns=").append(indexColumns);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}