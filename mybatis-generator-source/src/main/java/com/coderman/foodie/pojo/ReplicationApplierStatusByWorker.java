package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ReplicationApplierStatusByWorker implements Serializable {
    private String channelName;

    private Long workerId;

    private Long threadId;

    private String serviceState;

    private Integer lastErrorNumber;

    private String lastErrorMessage;

    private Date lastErrorTimestamp;

    private String lastAppliedTransaction;

    private Date lastAppliedTransactionOriginalCommitTimestamp;

    private Date lastAppliedTransactionImmediateCommitTimestamp;

    private Date lastAppliedTransactionStartApplyTimestamp;

    private Date lastAppliedTransactionEndApplyTimestamp;

    private String applyingTransaction;

    private Date applyingTransactionOriginalCommitTimestamp;

    private Date applyingTransactionImmediateCommitTimestamp;

    private Date applyingTransactionStartApplyTimestamp;

    private Long lastAppliedTransactionRetriesCount;

    private Integer lastAppliedTransactionLastTransientErrorNumber;

    private String lastAppliedTransactionLastTransientErrorMessage;

    private Date lastAppliedTransactionLastTransientErrorTimestamp;

    private Long applyingTransactionRetriesCount;

    private Integer applyingTransactionLastTransientErrorNumber;

    private String applyingTransactionLastTransientErrorMessage;

    private Date applyingTransactionLastTransientErrorTimestamp;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState == null ? null : serviceState.trim();
    }

    public Integer getLastErrorNumber() {
        return lastErrorNumber;
    }

    public void setLastErrorNumber(Integer lastErrorNumber) {
        this.lastErrorNumber = lastErrorNumber;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage == null ? null : lastErrorMessage.trim();
    }

    public Date getLastErrorTimestamp() {
        return lastErrorTimestamp;
    }

    public void setLastErrorTimestamp(Date lastErrorTimestamp) {
        this.lastErrorTimestamp = lastErrorTimestamp;
    }

    public String getLastAppliedTransaction() {
        return lastAppliedTransaction;
    }

    public void setLastAppliedTransaction(String lastAppliedTransaction) {
        this.lastAppliedTransaction = lastAppliedTransaction == null ? null : lastAppliedTransaction.trim();
    }

    public Date getLastAppliedTransactionOriginalCommitTimestamp() {
        return lastAppliedTransactionOriginalCommitTimestamp;
    }

    public void setLastAppliedTransactionOriginalCommitTimestamp(Date lastAppliedTransactionOriginalCommitTimestamp) {
        this.lastAppliedTransactionOriginalCommitTimestamp = lastAppliedTransactionOriginalCommitTimestamp;
    }

    public Date getLastAppliedTransactionImmediateCommitTimestamp() {
        return lastAppliedTransactionImmediateCommitTimestamp;
    }

    public void setLastAppliedTransactionImmediateCommitTimestamp(Date lastAppliedTransactionImmediateCommitTimestamp) {
        this.lastAppliedTransactionImmediateCommitTimestamp = lastAppliedTransactionImmediateCommitTimestamp;
    }

    public Date getLastAppliedTransactionStartApplyTimestamp() {
        return lastAppliedTransactionStartApplyTimestamp;
    }

    public void setLastAppliedTransactionStartApplyTimestamp(Date lastAppliedTransactionStartApplyTimestamp) {
        this.lastAppliedTransactionStartApplyTimestamp = lastAppliedTransactionStartApplyTimestamp;
    }

    public Date getLastAppliedTransactionEndApplyTimestamp() {
        return lastAppliedTransactionEndApplyTimestamp;
    }

    public void setLastAppliedTransactionEndApplyTimestamp(Date lastAppliedTransactionEndApplyTimestamp) {
        this.lastAppliedTransactionEndApplyTimestamp = lastAppliedTransactionEndApplyTimestamp;
    }

    public String getApplyingTransaction() {
        return applyingTransaction;
    }

    public void setApplyingTransaction(String applyingTransaction) {
        this.applyingTransaction = applyingTransaction == null ? null : applyingTransaction.trim();
    }

    public Date getApplyingTransactionOriginalCommitTimestamp() {
        return applyingTransactionOriginalCommitTimestamp;
    }

    public void setApplyingTransactionOriginalCommitTimestamp(Date applyingTransactionOriginalCommitTimestamp) {
        this.applyingTransactionOriginalCommitTimestamp = applyingTransactionOriginalCommitTimestamp;
    }

    public Date getApplyingTransactionImmediateCommitTimestamp() {
        return applyingTransactionImmediateCommitTimestamp;
    }

    public void setApplyingTransactionImmediateCommitTimestamp(Date applyingTransactionImmediateCommitTimestamp) {
        this.applyingTransactionImmediateCommitTimestamp = applyingTransactionImmediateCommitTimestamp;
    }

    public Date getApplyingTransactionStartApplyTimestamp() {
        return applyingTransactionStartApplyTimestamp;
    }

    public void setApplyingTransactionStartApplyTimestamp(Date applyingTransactionStartApplyTimestamp) {
        this.applyingTransactionStartApplyTimestamp = applyingTransactionStartApplyTimestamp;
    }

    public Long getLastAppliedTransactionRetriesCount() {
        return lastAppliedTransactionRetriesCount;
    }

    public void setLastAppliedTransactionRetriesCount(Long lastAppliedTransactionRetriesCount) {
        this.lastAppliedTransactionRetriesCount = lastAppliedTransactionRetriesCount;
    }

    public Integer getLastAppliedTransactionLastTransientErrorNumber() {
        return lastAppliedTransactionLastTransientErrorNumber;
    }

    public void setLastAppliedTransactionLastTransientErrorNumber(Integer lastAppliedTransactionLastTransientErrorNumber) {
        this.lastAppliedTransactionLastTransientErrorNumber = lastAppliedTransactionLastTransientErrorNumber;
    }

    public String getLastAppliedTransactionLastTransientErrorMessage() {
        return lastAppliedTransactionLastTransientErrorMessage;
    }

    public void setLastAppliedTransactionLastTransientErrorMessage(String lastAppliedTransactionLastTransientErrorMessage) {
        this.lastAppliedTransactionLastTransientErrorMessage = lastAppliedTransactionLastTransientErrorMessage == null ? null : lastAppliedTransactionLastTransientErrorMessage.trim();
    }

    public Date getLastAppliedTransactionLastTransientErrorTimestamp() {
        return lastAppliedTransactionLastTransientErrorTimestamp;
    }

    public void setLastAppliedTransactionLastTransientErrorTimestamp(Date lastAppliedTransactionLastTransientErrorTimestamp) {
        this.lastAppliedTransactionLastTransientErrorTimestamp = lastAppliedTransactionLastTransientErrorTimestamp;
    }

    public Long getApplyingTransactionRetriesCount() {
        return applyingTransactionRetriesCount;
    }

    public void setApplyingTransactionRetriesCount(Long applyingTransactionRetriesCount) {
        this.applyingTransactionRetriesCount = applyingTransactionRetriesCount;
    }

    public Integer getApplyingTransactionLastTransientErrorNumber() {
        return applyingTransactionLastTransientErrorNumber;
    }

    public void setApplyingTransactionLastTransientErrorNumber(Integer applyingTransactionLastTransientErrorNumber) {
        this.applyingTransactionLastTransientErrorNumber = applyingTransactionLastTransientErrorNumber;
    }

    public String getApplyingTransactionLastTransientErrorMessage() {
        return applyingTransactionLastTransientErrorMessage;
    }

    public void setApplyingTransactionLastTransientErrorMessage(String applyingTransactionLastTransientErrorMessage) {
        this.applyingTransactionLastTransientErrorMessage = applyingTransactionLastTransientErrorMessage == null ? null : applyingTransactionLastTransientErrorMessage.trim();
    }

    public Date getApplyingTransactionLastTransientErrorTimestamp() {
        return applyingTransactionLastTransientErrorTimestamp;
    }

    public void setApplyingTransactionLastTransientErrorTimestamp(Date applyingTransactionLastTransientErrorTimestamp) {
        this.applyingTransactionLastTransientErrorTimestamp = applyingTransactionLastTransientErrorTimestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", workerId=").append(workerId);
        sb.append(", threadId=").append(threadId);
        sb.append(", serviceState=").append(serviceState);
        sb.append(", lastErrorNumber=").append(lastErrorNumber);
        sb.append(", lastErrorMessage=").append(lastErrorMessage);
        sb.append(", lastErrorTimestamp=").append(lastErrorTimestamp);
        sb.append(", lastAppliedTransaction=").append(lastAppliedTransaction);
        sb.append(", lastAppliedTransactionOriginalCommitTimestamp=").append(lastAppliedTransactionOriginalCommitTimestamp);
        sb.append(", lastAppliedTransactionImmediateCommitTimestamp=").append(lastAppliedTransactionImmediateCommitTimestamp);
        sb.append(", lastAppliedTransactionStartApplyTimestamp=").append(lastAppliedTransactionStartApplyTimestamp);
        sb.append(", lastAppliedTransactionEndApplyTimestamp=").append(lastAppliedTransactionEndApplyTimestamp);
        sb.append(", applyingTransaction=").append(applyingTransaction);
        sb.append(", applyingTransactionOriginalCommitTimestamp=").append(applyingTransactionOriginalCommitTimestamp);
        sb.append(", applyingTransactionImmediateCommitTimestamp=").append(applyingTransactionImmediateCommitTimestamp);
        sb.append(", applyingTransactionStartApplyTimestamp=").append(applyingTransactionStartApplyTimestamp);
        sb.append(", lastAppliedTransactionRetriesCount=").append(lastAppliedTransactionRetriesCount);
        sb.append(", lastAppliedTransactionLastTransientErrorNumber=").append(lastAppliedTransactionLastTransientErrorNumber);
        sb.append(", lastAppliedTransactionLastTransientErrorMessage=").append(lastAppliedTransactionLastTransientErrorMessage);
        sb.append(", lastAppliedTransactionLastTransientErrorTimestamp=").append(lastAppliedTransactionLastTransientErrorTimestamp);
        sb.append(", applyingTransactionRetriesCount=").append(applyingTransactionRetriesCount);
        sb.append(", applyingTransactionLastTransientErrorNumber=").append(applyingTransactionLastTransientErrorNumber);
        sb.append(", applyingTransactionLastTransientErrorMessage=").append(applyingTransactionLastTransientErrorMessage);
        sb.append(", applyingTransactionLastTransientErrorTimestamp=").append(applyingTransactionLastTransientErrorTimestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}