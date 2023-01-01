package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class TablesPriv implements Serializable {
    private String host;

    private String db;

    private String user;

    private String tableName;

    private String grantor;

    private Date timestamp;

    private String tablePriv;

    private String columnPriv;

    private static final long serialVersionUID = 1L;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor == null ? null : grantor.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTablePriv() {
        return tablePriv;
    }

    public void setTablePriv(String tablePriv) {
        this.tablePriv = tablePriv == null ? null : tablePriv.trim();
    }

    public String getColumnPriv() {
        return columnPriv;
    }

    public void setColumnPriv(String columnPriv) {
        this.columnPriv = columnPriv == null ? null : columnPriv.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", host=").append(host);
        sb.append(", db=").append(db);
        sb.append(", user=").append(user);
        sb.append(", tableName=").append(tableName);
        sb.append(", grantor=").append(grantor);
        sb.append(", timestamp=").append(timestamp);
        sb.append(", tablePriv=").append(tablePriv);
        sb.append(", columnPriv=").append(columnPriv);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}