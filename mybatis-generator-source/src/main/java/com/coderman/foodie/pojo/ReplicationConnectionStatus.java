package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ReplicationConnectionStatus implements Serializable {
    private String channelName;

    private String groupName;

    private String sourceUuid;

    private Long threadId;

    private String serviceState;

    private Long countReceivedHeartbeats;

    private Date lastHeartbeatTimestamp;

    private Integer lastErrorNumber;

    private String lastErrorMessage;

    private Date lastErrorTimestamp;

    private String lastQueuedTransaction;

    private Date lastQueuedTransactionOriginalCommitTimestamp;

    private Date lastQueuedTransactionImmediateCommitTimestamp;

    private Date lastQueuedTransactionStartQueueTimestamp;

    private Date lastQueuedTransactionEndQueueTimestamp;

    private String queueingTransaction;

    private Date queueingTransactionOriginalCommitTimestamp;

    private Date queueingTransactionImmediateCommitTimestamp;

    private Date queueingTransactionStartQueueTimestamp;

    private String receivedTransactionSet;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getSourceUuid() {
        return sourceUuid;
    }

    public void setSourceUuid(String sourceUuid) {
        this.sourceUuid = sourceUuid == null ? null : sourceUuid.trim();
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

    public Long getCountReceivedHeartbeats() {
        return countReceivedHeartbeats;
    }

    public void setCountReceivedHeartbeats(Long countReceivedHeartbeats) {
        this.countReceivedHeartbeats = countReceivedHeartbeats;
    }

    public Date getLastHeartbeatTimestamp() {
        return lastHeartbeatTimestamp;
    }

    public void setLastHeartbeatTimestamp(Date lastHeartbeatTimestamp) {
        this.lastHeartbeatTimestamp = lastHeartbeatTimestamp;
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

    public String getLastQueuedTransaction() {
        return lastQueuedTransaction;
    }

    public void setLastQueuedTransaction(String lastQueuedTransaction) {
        this.lastQueuedTransaction = lastQueuedTransaction == null ? null : lastQueuedTransaction.trim();
    }

    public Date getLastQueuedTransactionOriginalCommitTimestamp() {
        return lastQueuedTransactionOriginalCommitTimestamp;
    }

    public void setLastQueuedTransactionOriginalCommitTimestamp(Date lastQueuedTransactionOriginalCommitTimestamp) {
        this.lastQueuedTransactionOriginalCommitTimestamp = lastQueuedTransactionOriginalCommitTimestamp;
    }

    public Date getLastQueuedTransactionImmediateCommitTimestamp() {
        return lastQueuedTransactionImmediateCommitTimestamp;
    }

    public void setLastQueuedTransactionImmediateCommitTimestamp(Date lastQueuedTransactionImmediateCommitTimestamp) {
        this.lastQueuedTransactionImmediateCommitTimestamp = lastQueuedTransactionImmediateCommitTimestamp;
    }

    public Date getLastQueuedTransactionStartQueueTimestamp() {
        return lastQueuedTransactionStartQueueTimestamp;
    }

    public void setLastQueuedTransactionStartQueueTimestamp(Date lastQueuedTransactionStartQueueTimestamp) {
        this.lastQueuedTransactionStartQueueTimestamp = lastQueuedTransactionStartQueueTimestamp;
    }

    public Date getLastQueuedTransactionEndQueueTimestamp() {
        return lastQueuedTransactionEndQueueTimestamp;
    }

    public void setLastQueuedTransactionEndQueueTimestamp(Date lastQueuedTransactionEndQueueTimestamp) {
        this.lastQueuedTransactionEndQueueTimestamp = lastQueuedTransactionEndQueueTimestamp;
    }

    public String getQueueingTransaction() {
        return queueingTransaction;
    }

    public void setQueueingTransaction(String queueingTransaction) {
        this.queueingTransaction = queueingTransaction == null ? null : queueingTransaction.trim();
    }

    public Date getQueueingTransactionOriginalCommitTimestamp() {
        return queueingTransactionOriginalCommitTimestamp;
    }

    public void setQueueingTransactionOriginalCommitTimestamp(Date queueingTransactionOriginalCommitTimestamp) {
        this.queueingTransactionOriginalCommitTimestamp = queueingTransactionOriginalCommitTimestamp;
    }

    public Date getQueueingTransactionImmediateCommitTimestamp() {
        return queueingTransactionImmediateCommitTimestamp;
    }

    public void setQueueingTransactionImmediateCommitTimestamp(Date queueingTransactionImmediateCommitTimestamp) {
        this.queueingTransactionImmediateCommitTimestamp = queueingTransactionImmediateCommitTimestamp;
    }

    public Date getQueueingTransactionStartQueueTimestamp() {
        return queueingTransactionStartQueueTimestamp;
    }

    public void setQueueingTransactionStartQueueTimestamp(Date queueingTransactionStartQueueTimestamp) {
        this.queueingTransactionStartQueueTimestamp = queueingTransactionStartQueueTimestamp;
    }

    public String getReceivedTransactionSet() {
        return receivedTransactionSet;
    }

    public void setReceivedTransactionSet(String receivedTransactionSet) {
        this.receivedTransactionSet = receivedTransactionSet == null ? null : receivedTransactionSet.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", groupName=").append(groupName);
        sb.append(", sourceUuid=").append(sourceUuid);
        sb.append(", threadId=").append(threadId);
        sb.append(", serviceState=").append(serviceState);
        sb.append(", countReceivedHeartbeats=").append(countReceivedHeartbeats);
        sb.append(", lastHeartbeatTimestamp=").append(lastHeartbeatTimestamp);
        sb.append(", lastErrorNumber=").append(lastErrorNumber);
        sb.append(", lastErrorMessage=").append(lastErrorMessage);
        sb.append(", lastErrorTimestamp=").append(lastErrorTimestamp);
        sb.append(", lastQueuedTransaction=").append(lastQueuedTransaction);
        sb.append(", lastQueuedTransactionOriginalCommitTimestamp=").append(lastQueuedTransactionOriginalCommitTimestamp);
        sb.append(", lastQueuedTransactionImmediateCommitTimestamp=").append(lastQueuedTransactionImmediateCommitTimestamp);
        sb.append(", lastQueuedTransactionStartQueueTimestamp=").append(lastQueuedTransactionStartQueueTimestamp);
        sb.append(", lastQueuedTransactionEndQueueTimestamp=").append(lastQueuedTransactionEndQueueTimestamp);
        sb.append(", queueingTransaction=").append(queueingTransaction);
        sb.append(", queueingTransactionOriginalCommitTimestamp=").append(queueingTransactionOriginalCommitTimestamp);
        sb.append(", queueingTransactionImmediateCommitTimestamp=").append(queueingTransactionImmediateCommitTimestamp);
        sb.append(", queueingTransactionStartQueueTimestamp=").append(queueingTransactionStartQueueTimestamp);
        sb.append(", receivedTransactionSet=").append(receivedTransactionSet);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}