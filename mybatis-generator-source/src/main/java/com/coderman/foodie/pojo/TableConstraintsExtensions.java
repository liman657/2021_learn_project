package com.coderman.foodie.pojo;

import java.io.Serializable;

public class TableConstraintsExtensions implements Serializable {
    private String constraintCatalog;

    private String constraintSchema;

    private String constraintName;

    private String tableName;

    private String engineAttribute;

    private String secondaryEngineAttribute;

    private static final long serialVersionUID = 1L;

    public String getConstraintCatalog() {
        return constraintCatalog;
    }

    public void setConstraintCatalog(String constraintCatalog) {
        this.constraintCatalog = constraintCatalog == null ? null : constraintCatalog.trim();
    }

    public String getConstraintSchema() {
        return constraintSchema;
    }

    public void setConstraintSchema(String constraintSchema) {
        this.constraintSchema = constraintSchema == null ? null : constraintSchema.trim();
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName == null ? null : constraintName.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getEngineAttribute() {
        return engineAttribute;
    }

    public void setEngineAttribute(String engineAttribute) {
        this.engineAttribute = engineAttribute == null ? null : engineAttribute.trim();
    }

    public String getSecondaryEngineAttribute() {
        return secondaryEngineAttribute;
    }

    public void setSecondaryEngineAttribute(String secondaryEngineAttribute) {
        this.secondaryEngineAttribute = secondaryEngineAttribute == null ? null : secondaryEngineAttribute.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", constraintCatalog=").append(constraintCatalog);
        sb.append(", constraintSchema=").append(constraintSchema);
        sb.append(", constraintName=").append(constraintName);
        sb.append(", tableName=").append(tableName);
        sb.append(", engineAttribute=").append(engineAttribute);
        sb.append(", secondaryEngineAttribute=").append(secondaryEngineAttribute);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}