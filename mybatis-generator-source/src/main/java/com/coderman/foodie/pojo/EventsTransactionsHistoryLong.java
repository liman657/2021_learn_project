package com.coderman.foodie.pojo;

import java.io.Serializable;

public class EventsTransactionsHistoryLong implements Serializable {
    private Long threadId;

    private Long eventId;

    private Long endEventId;

    private String eventName;

    private String state;

    private Long trxId;

    private String gtid;

    private Integer xidFormatId;

    private String xidGtrid;

    private String xidBqual;

    private String xaState;

    private String source;

    private Long timerStart;

    private Long timerEnd;

    private Long timerWait;

    private String accessMode;

    private String isolationLevel;

    private String autocommit;

    private Long numberOfSavepoints;

    private Long numberOfRollbackToSavepoint;

    private Long numberOfReleaseSavepoint;

    private Long objectInstanceBegin;

    private Long nestingEventId;

    private String nestingEventType;

    private static final long serialVersionUID = 1L;

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEndEventId() {
        return endEventId;
    }

    public void setEndEventId(Long endEventId) {
        this.endEventId = endEventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getTrxId() {
        return trxId;
    }

    public void setTrxId(Long trxId) {
        this.trxId = trxId;
    }

    public String getGtid() {
        return gtid;
    }

    public void setGtid(String gtid) {
        this.gtid = gtid == null ? null : gtid.trim();
    }

    public Integer getXidFormatId() {
        return xidFormatId;
    }

    public void setXidFormatId(Integer xidFormatId) {
        this.xidFormatId = xidFormatId;
    }

    public String getXidGtrid() {
        return xidGtrid;
    }

    public void setXidGtrid(String xidGtrid) {
        this.xidGtrid = xidGtrid == null ? null : xidGtrid.trim();
    }

    public String getXidBqual() {
        return xidBqual;
    }

    public void setXidBqual(String xidBqual) {
        this.xidBqual = xidBqual == null ? null : xidBqual.trim();
    }

    public String getXaState() {
        return xaState;
    }

    public void setXaState(String xaState) {
        this.xaState = xaState == null ? null : xaState.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Long getTimerStart() {
        return timerStart;
    }

    public void setTimerStart(Long timerStart) {
        this.timerStart = timerStart;
    }

    public Long getTimerEnd() {
        return timerEnd;
    }

    public void setTimerEnd(Long timerEnd) {
        this.timerEnd = timerEnd;
    }

    public Long getTimerWait() {
        return timerWait;
    }

    public void setTimerWait(Long timerWait) {
        this.timerWait = timerWait;
    }

    public String getAccessMode() {
        return accessMode;
    }

    public void setAccessMode(String accessMode) {
        this.accessMode = accessMode == null ? null : accessMode.trim();
    }

    public String getIsolationLevel() {
        return isolationLevel;
    }

    public void setIsolationLevel(String isolationLevel) {
        this.isolationLevel = isolationLevel == null ? null : isolationLevel.trim();
    }

    public String getAutocommit() {
        return autocommit;
    }

    public void setAutocommit(String autocommit) {
        this.autocommit = autocommit == null ? null : autocommit.trim();
    }

    public Long getNumberOfSavepoints() {
        return numberOfSavepoints;
    }

    public void setNumberOfSavepoints(Long numberOfSavepoints) {
        this.numberOfSavepoints = numberOfSavepoints;
    }

    public Long getNumberOfRollbackToSavepoint() {
        return numberOfRollbackToSavepoint;
    }

    public void setNumberOfRollbackToSavepoint(Long numberOfRollbackToSavepoint) {
        this.numberOfRollbackToSavepoint = numberOfRollbackToSavepoint;
    }

    public Long getNumberOfReleaseSavepoint() {
        return numberOfReleaseSavepoint;
    }

    public void setNumberOfReleaseSavepoint(Long numberOfReleaseSavepoint) {
        this.numberOfReleaseSavepoint = numberOfReleaseSavepoint;
    }

    public Long getObjectInstanceBegin() {
        return objectInstanceBegin;
    }

    public void setObjectInstanceBegin(Long objectInstanceBegin) {
        this.objectInstanceBegin = objectInstanceBegin;
    }

    public Long getNestingEventId() {
        return nestingEventId;
    }

    public void setNestingEventId(Long nestingEventId) {
        this.nestingEventId = nestingEventId;
    }

    public String getNestingEventType() {
        return nestingEventType;
    }

    public void setNestingEventType(String nestingEventType) {
        this.nestingEventType = nestingEventType == null ? null : nestingEventType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", threadId=").append(threadId);
        sb.append(", eventId=").append(eventId);
        sb.append(", endEventId=").append(endEventId);
        sb.append(", eventName=").append(eventName);
        sb.append(", state=").append(state);
        sb.append(", trxId=").append(trxId);
        sb.append(", gtid=").append(gtid);
        sb.append(", xidFormatId=").append(xidFormatId);
        sb.append(", xidGtrid=").append(xidGtrid);
        sb.append(", xidBqual=").append(xidBqual);
        sb.append(", xaState=").append(xaState);
        sb.append(", source=").append(source);
        sb.append(", timerStart=").append(timerStart);
        sb.append(", timerEnd=").append(timerEnd);
        sb.append(", timerWait=").append(timerWait);
        sb.append(", accessMode=").append(accessMode);
        sb.append(", isolationLevel=").append(isolationLevel);
        sb.append(", autocommit=").append(autocommit);
        sb.append(", numberOfSavepoints=").append(numberOfSavepoints);
        sb.append(", numberOfRollbackToSavepoint=").append(numberOfRollbackToSavepoint);
        sb.append(", numberOfReleaseSavepoint=").append(numberOfReleaseSavepoint);
        sb.append(", objectInstanceBegin=").append(objectInstanceBegin);
        sb.append(", nestingEventId=").append(nestingEventId);
        sb.append(", nestingEventType=").append(nestingEventType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}