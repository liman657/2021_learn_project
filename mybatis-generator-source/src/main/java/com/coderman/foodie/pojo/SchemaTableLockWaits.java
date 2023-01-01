package com.coderman.foodie.pojo;

import java.io.Serializable;

public class SchemaTableLockWaits implements Serializable {
    private String objectSchema;

    private String objectName;

    private Long waitingThreadId;

    private Long waitingPid;

    private String waitingLockType;

    private String waitingLockDuration;

    private Long waitingQuerySecs;

    private Long waitingQueryRowsAffected;

    private Long waitingQueryRowsExamined;

    private Long blockingThreadId;

    private Long blockingPid;

    private String blockingLockType;

    private String blockingLockDuration;

    private String sqlKillBlockingQuery;

    private String sqlKillBlockingConnection;

    private String waitingAccount;

    private String waitingQuery;

    private String blockingAccount;

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

    public Long getWaitingThreadId() {
        return waitingThreadId;
    }

    public void setWaitingThreadId(Long waitingThreadId) {
        this.waitingThreadId = waitingThreadId;
    }

    public Long getWaitingPid() {
        return waitingPid;
    }

    public void setWaitingPid(Long waitingPid) {
        this.waitingPid = waitingPid;
    }

    public String getWaitingLockType() {
        return waitingLockType;
    }

    public void setWaitingLockType(String waitingLockType) {
        this.waitingLockType = waitingLockType == null ? null : waitingLockType.trim();
    }

    public String getWaitingLockDuration() {
        return waitingLockDuration;
    }

    public void setWaitingLockDuration(String waitingLockDuration) {
        this.waitingLockDuration = waitingLockDuration == null ? null : waitingLockDuration.trim();
    }

    public Long getWaitingQuerySecs() {
        return waitingQuerySecs;
    }

    public void setWaitingQuerySecs(Long waitingQuerySecs) {
        this.waitingQuerySecs = waitingQuerySecs;
    }

    public Long getWaitingQueryRowsAffected() {
        return waitingQueryRowsAffected;
    }

    public void setWaitingQueryRowsAffected(Long waitingQueryRowsAffected) {
        this.waitingQueryRowsAffected = waitingQueryRowsAffected;
    }

    public Long getWaitingQueryRowsExamined() {
        return waitingQueryRowsExamined;
    }

    public void setWaitingQueryRowsExamined(Long waitingQueryRowsExamined) {
        this.waitingQueryRowsExamined = waitingQueryRowsExamined;
    }

    public Long getBlockingThreadId() {
        return blockingThreadId;
    }

    public void setBlockingThreadId(Long blockingThreadId) {
        this.blockingThreadId = blockingThreadId;
    }

    public Long getBlockingPid() {
        return blockingPid;
    }

    public void setBlockingPid(Long blockingPid) {
        this.blockingPid = blockingPid;
    }

    public String getBlockingLockType() {
        return blockingLockType;
    }

    public void setBlockingLockType(String blockingLockType) {
        this.blockingLockType = blockingLockType == null ? null : blockingLockType.trim();
    }

    public String getBlockingLockDuration() {
        return blockingLockDuration;
    }

    public void setBlockingLockDuration(String blockingLockDuration) {
        this.blockingLockDuration = blockingLockDuration == null ? null : blockingLockDuration.trim();
    }

    public String getSqlKillBlockingQuery() {
        return sqlKillBlockingQuery;
    }

    public void setSqlKillBlockingQuery(String sqlKillBlockingQuery) {
        this.sqlKillBlockingQuery = sqlKillBlockingQuery == null ? null : sqlKillBlockingQuery.trim();
    }

    public String getSqlKillBlockingConnection() {
        return sqlKillBlockingConnection;
    }

    public void setSqlKillBlockingConnection(String sqlKillBlockingConnection) {
        this.sqlKillBlockingConnection = sqlKillBlockingConnection == null ? null : sqlKillBlockingConnection.trim();
    }

    public String getWaitingAccount() {
        return waitingAccount;
    }

    public void setWaitingAccount(String waitingAccount) {
        this.waitingAccount = waitingAccount == null ? null : waitingAccount.trim();
    }

    public String getWaitingQuery() {
        return waitingQuery;
    }

    public void setWaitingQuery(String waitingQuery) {
        this.waitingQuery = waitingQuery == null ? null : waitingQuery.trim();
    }

    public String getBlockingAccount() {
        return blockingAccount;
    }

    public void setBlockingAccount(String blockingAccount) {
        this.blockingAccount = blockingAccount == null ? null : blockingAccount.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", objectSchema=").append(objectSchema);
        sb.append(", objectName=").append(objectName);
        sb.append(", waitingThreadId=").append(waitingThreadId);
        sb.append(", waitingPid=").append(waitingPid);
        sb.append(", waitingLockType=").append(waitingLockType);
        sb.append(", waitingLockDuration=").append(waitingLockDuration);
        sb.append(", waitingQuerySecs=").append(waitingQuerySecs);
        sb.append(", waitingQueryRowsAffected=").append(waitingQueryRowsAffected);
        sb.append(", waitingQueryRowsExamined=").append(waitingQueryRowsExamined);
        sb.append(", blockingThreadId=").append(blockingThreadId);
        sb.append(", blockingPid=").append(blockingPid);
        sb.append(", blockingLockType=").append(blockingLockType);
        sb.append(", blockingLockDuration=").append(blockingLockDuration);
        sb.append(", sqlKillBlockingQuery=").append(sqlKillBlockingQuery);
        sb.append(", sqlKillBlockingConnection=").append(sqlKillBlockingConnection);
        sb.append(", waitingAccount=").append(waitingAccount);
        sb.append(", waitingQuery=").append(waitingQuery);
        sb.append(", blockingAccount=").append(blockingAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}