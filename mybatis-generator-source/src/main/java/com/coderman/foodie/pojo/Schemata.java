package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Schemata implements Serializable {
    private String catalogName;

    private String schemaName;

    private String defaultCharacterSetName;

    private String defaultCollationName;

    private String defaultEncryption;

    private byte[] sqlPath;

    private static final long serialVersionUID = 1L;

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    public String getDefaultCharacterSetName() {
        return defaultCharacterSetName;
    }

    public void setDefaultCharacterSetName(String defaultCharacterSetName) {
        this.defaultCharacterSetName = defaultCharacterSetName == null ? null : defaultCharacterSetName.trim();
    }

    public String getDefaultCollationName() {
        return defaultCollationName;
    }

    public void setDefaultCollationName(String defaultCollationName) {
        this.defaultCollationName = defaultCollationName == null ? null : defaultCollationName.trim();
    }

    public String getDefaultEncryption() {
        return defaultEncryption;
    }

    public void setDefaultEncryption(String defaultEncryption) {
        this.defaultEncryption = defaultEncryption == null ? null : defaultEncryption.trim();
    }

    public byte[] getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(byte[] sqlPath) {
        this.sqlPath = sqlPath;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", catalogName=").append(catalogName);
        sb.append(", schemaName=").append(schemaName);
        sb.append(", defaultCharacterSetName=").append(defaultCharacterSetName);
        sb.append(", defaultCollationName=").append(defaultCollationName);
        sb.append(", defaultEncryption=").append(defaultEncryption);
        sb.append(", sqlPath=").append(sqlPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}