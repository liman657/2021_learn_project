package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class InnodbTrx implements Serializable {
    private Long trxId;

    private String trxState;

    private Date trxStarted;

    private String trxRequestedLockId;

    private Date trxWaitStarted;

    private Long trxWeight;

    private Long trxMysqlThreadId;

    private String trxQuery;

    private String trxOperationState;

    private Long trxTablesInUse;

    private Long trxTablesLocked;

    private Long trxLockStructs;

    private Long trxLockMemoryBytes;

    private Long trxRowsLocked;

    private Long trxRowsModified;

    private Long trxConcurrencyTickets;

    private String trxIsolationLevel;

    private Integer trxUniqueChecks;

    private Integer trxForeignKeyChecks;

    private String trxLastForeignKeyError;

    private Integer trxAdaptiveHashLatched;

    private Long trxAdaptiveHashTimeout;

    private Integer trxIsReadOnly;

    private Integer trxAutocommitNonLocking;

    private Long trxScheduleWeight;

    private static final long serialVersionUID = 1L;

    public Long getTrxId() {
        return trxId;
    }

    public void setTrxId(Long trxId) {
        this.trxId = trxId;
    }

    public String getTrxState() {
        return trxState;
    }

    public void setTrxState(String trxState) {
        this.trxState = trxState == null ? null : trxState.trim();
    }

    public Date getTrxStarted() {
        return trxStarted;
    }

    public void setTrxStarted(Date trxStarted) {
        this.trxStarted = trxStarted;
    }

    public String getTrxRequestedLockId() {
        return trxRequestedLockId;
    }

    public void setTrxRequestedLockId(String trxRequestedLockId) {
        this.trxRequestedLockId = trxRequestedLockId == null ? null : trxRequestedLockId.trim();
    }

    public Date getTrxWaitStarted() {
        return trxWaitStarted;
    }

    public void setTrxWaitStarted(Date trxWaitStarted) {
        this.trxWaitStarted = trxWaitStarted;
    }

    public Long getTrxWeight() {
        return trxWeight;
    }

    public void setTrxWeight(Long trxWeight) {
        this.trxWeight = trxWeight;
    }

    public Long getTrxMysqlThreadId() {
        return trxMysqlThreadId;
    }

    public void setTrxMysqlThreadId(Long trxMysqlThreadId) {
        this.trxMysqlThreadId = trxMysqlThreadId;
    }

    public String getTrxQuery() {
        return trxQuery;
    }

    public void setTrxQuery(String trxQuery) {
        this.trxQuery = trxQuery == null ? null : trxQuery.trim();
    }

    public String getTrxOperationState() {
        return trxOperationState;
    }

    public void setTrxOperationState(String trxOperationState) {
        this.trxOperationState = trxOperationState == null ? null : trxOperationState.trim();
    }

    public Long getTrxTablesInUse() {
        return trxTablesInUse;
    }

    public void setTrxTablesInUse(Long trxTablesInUse) {
        this.trxTablesInUse = trxTablesInUse;
    }

    public Long getTrxTablesLocked() {
        return trxTablesLocked;
    }

    public void setTrxTablesLocked(Long trxTablesLocked) {
        this.trxTablesLocked = trxTablesLocked;
    }

    public Long getTrxLockStructs() {
        return trxLockStructs;
    }

    public void setTrxLockStructs(Long trxLockStructs) {
        this.trxLockStructs = trxLockStructs;
    }

    public Long getTrxLockMemoryBytes() {
        return trxLockMemoryBytes;
    }

    public void setTrxLockMemoryBytes(Long trxLockMemoryBytes) {
        this.trxLockMemoryBytes = trxLockMemoryBytes;
    }

    public Long getTrxRowsLocked() {
        return trxRowsLocked;
    }

    public void setTrxRowsLocked(Long trxRowsLocked) {
        this.trxRowsLocked = trxRowsLocked;
    }

    public Long getTrxRowsModified() {
        return trxRowsModified;
    }

    public void setTrxRowsModified(Long trxRowsModified) {
        this.trxRowsModified = trxRowsModified;
    }

    public Long getTrxConcurrencyTickets() {
        return trxConcurrencyTickets;
    }

    public void setTrxConcurrencyTickets(Long trxConcurrencyTickets) {
        this.trxConcurrencyTickets = trxConcurrencyTickets;
    }

    public String getTrxIsolationLevel() {
        return trxIsolationLevel;
    }

    public void setTrxIsolationLevel(String trxIsolationLevel) {
        this.trxIsolationLevel = trxIsolationLevel == null ? null : trxIsolationLevel.trim();
    }

    public Integer getTrxUniqueChecks() {
        return trxUniqueChecks;
    }

    public void setTrxUniqueChecks(Integer trxUniqueChecks) {
        this.trxUniqueChecks = trxUniqueChecks;
    }

    public Integer getTrxForeignKeyChecks() {
        return trxForeignKeyChecks;
    }

    public void setTrxForeignKeyChecks(Integer trxForeignKeyChecks) {
        this.trxForeignKeyChecks = trxForeignKeyChecks;
    }

    public String getTrxLastForeignKeyError() {
        return trxLastForeignKeyError;
    }

    public void setTrxLastForeignKeyError(String trxLastForeignKeyError) {
        this.trxLastForeignKeyError = trxLastForeignKeyError == null ? null : trxLastForeignKeyError.trim();
    }

    public Integer getTrxAdaptiveHashLatched() {
        return trxAdaptiveHashLatched;
    }

    public void setTrxAdaptiveHashLatched(Integer trxAdaptiveHashLatched) {
        this.trxAdaptiveHashLatched = trxAdaptiveHashLatched;
    }

    public Long getTrxAdaptiveHashTimeout() {
        return trxAdaptiveHashTimeout;
    }

    public void setTrxAdaptiveHashTimeout(Long trxAdaptiveHashTimeout) {
        this.trxAdaptiveHashTimeout = trxAdaptiveHashTimeout;
    }

    public Integer getTrxIsReadOnly() {
        return trxIsReadOnly;
    }

    public void setTrxIsReadOnly(Integer trxIsReadOnly) {
        this.trxIsReadOnly = trxIsReadOnly;
    }

    public Integer getTrxAutocommitNonLocking() {
        return trxAutocommitNonLocking;
    }

    public void setTrxAutocommitNonLocking(Integer trxAutocommitNonLocking) {
        this.trxAutocommitNonLocking = trxAutocommitNonLocking;
    }

    public Long getTrxScheduleWeight() {
        return trxScheduleWeight;
    }

    public void setTrxScheduleWeight(Long trxScheduleWeight) {
        this.trxScheduleWeight = trxScheduleWeight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", trxId=").append(trxId);
        sb.append(", trxState=").append(trxState);
        sb.append(", trxStarted=").append(trxStarted);
        sb.append(", trxRequestedLockId=").append(trxRequestedLockId);
        sb.append(", trxWaitStarted=").append(trxWaitStarted);
        sb.append(", trxWeight=").append(trxWeight);
        sb.append(", trxMysqlThreadId=").append(trxMysqlThreadId);
        sb.append(", trxQuery=").append(trxQuery);
        sb.append(", trxOperationState=").append(trxOperationState);
        sb.append(", trxTablesInUse=").append(trxTablesInUse);
        sb.append(", trxTablesLocked=").append(trxTablesLocked);
        sb.append(", trxLockStructs=").append(trxLockStructs);
        sb.append(", trxLockMemoryBytes=").append(trxLockMemoryBytes);
        sb.append(", trxRowsLocked=").append(trxRowsLocked);
        sb.append(", trxRowsModified=").append(trxRowsModified);
        sb.append(", trxConcurrencyTickets=").append(trxConcurrencyTickets);
        sb.append(", trxIsolationLevel=").append(trxIsolationLevel);
        sb.append(", trxUniqueChecks=").append(trxUniqueChecks);
        sb.append(", trxForeignKeyChecks=").append(trxForeignKeyChecks);
        sb.append(", trxLastForeignKeyError=").append(trxLastForeignKeyError);
        sb.append(", trxAdaptiveHashLatched=").append(trxAdaptiveHashLatched);
        sb.append(", trxAdaptiveHashTimeout=").append(trxAdaptiveHashTimeout);
        sb.append(", trxIsReadOnly=").append(trxIsReadOnly);
        sb.append(", trxAutocommitNonLocking=").append(trxAutocommitNonLocking);
        sb.append(", trxScheduleWeight=").append(trxScheduleWeight);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}