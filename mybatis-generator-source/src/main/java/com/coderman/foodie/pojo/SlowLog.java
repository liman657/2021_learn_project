package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class SlowLog implements Serializable {
    private Date startTime;

    private Date queryTime;

    private Date lockTime;

    private Integer rowsSent;

    private Integer rowsExamined;

    private String db;

    private Integer lastInsertId;

    private Integer insertId;

    private Integer serverId;

    private Long threadId;

    private String userHost;

    private byte[] sqlText;

    private static final long serialVersionUID = 1L;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Integer getRowsSent() {
        return rowsSent;
    }

    public void setRowsSent(Integer rowsSent) {
        this.rowsSent = rowsSent;
    }

    public Integer getRowsExamined() {
        return rowsExamined;
    }

    public void setRowsExamined(Integer rowsExamined) {
        this.rowsExamined = rowsExamined;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db == null ? null : db.trim();
    }

    public Integer getLastInsertId() {
        return lastInsertId;
    }

    public void setLastInsertId(Integer lastInsertId) {
        this.lastInsertId = lastInsertId;
    }

    public Integer getInsertId() {
        return insertId;
    }

    public void setInsertId(Integer insertId) {
        this.insertId = insertId;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getUserHost() {
        return userHost;
    }

    public void setUserHost(String userHost) {
        this.userHost = userHost == null ? null : userHost.trim();
    }

    public byte[] getSqlText() {
        return sqlText;
    }

    public void setSqlText(byte[] sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", startTime=").append(startTime);
        sb.append(", queryTime=").append(queryTime);
        sb.append(", lockTime=").append(lockTime);
        sb.append(", rowsSent=").append(rowsSent);
        sb.append(", rowsExamined=").append(rowsExamined);
        sb.append(", db=").append(db);
        sb.append(", lastInsertId=").append(lastInsertId);
        sb.append(", insertId=").append(insertId);
        sb.append(", serverId=").append(serverId);
        sb.append(", threadId=").append(threadId);
        sb.append(", userHost=").append(userHost);
        sb.append(", sqlText=").append(sqlText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}