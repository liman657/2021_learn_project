package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Profiling implements Serializable {
    private Integer queryId;

    private Integer seq;

    private String state;

    private Short duration;

    private Short cpuUser;

    private Short cpuSystem;

    private Integer contextVoluntary;

    private Integer contextInvoluntary;

    private Integer blockOpsIn;

    private Integer blockOpsOut;

    private Integer messagesSent;

    private Integer messagesReceived;

    private Integer pageFaultsMajor;

    private Integer pageFaultsMinor;

    private Integer swaps;

    private String sourceFunction;

    private String sourceFile;

    private Integer sourceLine;

    private static final long serialVersionUID = 1L;

    public Integer getQueryId() {
        return queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Short getDuration() {
        return duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }

    public Short getCpuUser() {
        return cpuUser;
    }

    public void setCpuUser(Short cpuUser) {
        this.cpuUser = cpuUser;
    }

    public Short getCpuSystem() {
        return cpuSystem;
    }

    public void setCpuSystem(Short cpuSystem) {
        this.cpuSystem = cpuSystem;
    }

    public Integer getContextVoluntary() {
        return contextVoluntary;
    }

    public void setContextVoluntary(Integer contextVoluntary) {
        this.contextVoluntary = contextVoluntary;
    }

    public Integer getContextInvoluntary() {
        return contextInvoluntary;
    }

    public void setContextInvoluntary(Integer contextInvoluntary) {
        this.contextInvoluntary = contextInvoluntary;
    }

    public Integer getBlockOpsIn() {
        return blockOpsIn;
    }

    public void setBlockOpsIn(Integer blockOpsIn) {
        this.blockOpsIn = blockOpsIn;
    }

    public Integer getBlockOpsOut() {
        return blockOpsOut;
    }

    public void setBlockOpsOut(Integer blockOpsOut) {
        this.blockOpsOut = blockOpsOut;
    }

    public Integer getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(Integer messagesSent) {
        this.messagesSent = messagesSent;
    }

    public Integer getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(Integer messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    public Integer getPageFaultsMajor() {
        return pageFaultsMajor;
    }

    public void setPageFaultsMajor(Integer pageFaultsMajor) {
        this.pageFaultsMajor = pageFaultsMajor;
    }

    public Integer getPageFaultsMinor() {
        return pageFaultsMinor;
    }

    public void setPageFaultsMinor(Integer pageFaultsMinor) {
        this.pageFaultsMinor = pageFaultsMinor;
    }

    public Integer getSwaps() {
        return swaps;
    }

    public void setSwaps(Integer swaps) {
        this.swaps = swaps;
    }

    public String getSourceFunction() {
        return sourceFunction;
    }

    public void setSourceFunction(String sourceFunction) {
        this.sourceFunction = sourceFunction == null ? null : sourceFunction.trim();
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile == null ? null : sourceFile.trim();
    }

    public Integer getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(Integer sourceLine) {
        this.sourceLine = sourceLine;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", queryId=").append(queryId);
        sb.append(", seq=").append(seq);
        sb.append(", state=").append(state);
        sb.append(", duration=").append(duration);
        sb.append(", cpuUser=").append(cpuUser);
        sb.append(", cpuSystem=").append(cpuSystem);
        sb.append(", contextVoluntary=").append(contextVoluntary);
        sb.append(", contextInvoluntary=").append(contextInvoluntary);
        sb.append(", blockOpsIn=").append(blockOpsIn);
        sb.append(", blockOpsOut=").append(blockOpsOut);
        sb.append(", messagesSent=").append(messagesSent);
        sb.append(", messagesReceived=").append(messagesReceived);
        sb.append(", pageFaultsMajor=").append(pageFaultsMajor);
        sb.append(", pageFaultsMinor=").append(pageFaultsMinor);
        sb.append(", swaps=").append(swaps);
        sb.append(", sourceFunction=").append(sourceFunction);
        sb.append(", sourceFile=").append(sourceFile);
        sb.append(", sourceLine=").append(sourceLine);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}