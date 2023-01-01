package com.coderman.foodie.pojo;

import java.io.Serializable;

public class ViewTableUsage implements Serializable {
    private String viewCatalog;

    private String viewSchema;

    private String viewName;

    private String tableCatalog;

    private String tableSchema;

    private String tableName;

    private static final long serialVersionUID = 1L;

    public String getViewCatalog() {
        return viewCatalog;
    }

    public void setViewCatalog(String viewCatalog) {
        this.viewCatalog = viewCatalog == null ? null : viewCatalog.trim();
    }

    public String getViewSchema() {
        return viewSchema;
    }

    public void setViewSchema(String viewSchema) {
        this.viewSchema = viewSchema == null ? null : viewSchema.trim();
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName == null ? null : viewName.trim();
    }

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog == null ? null : tableCatalog.trim();
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", viewCatalog=").append(viewCatalog);
        sb.append(", viewSchema=").append(viewSchema);
        sb.append(", viewName=").append(viewName);
        sb.append(", tableCatalog=").append(tableCatalog);
        sb.append(", tableSchema=").append(tableSchema);
        sb.append(", tableName=").append(tableName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}