package com.coderman.foodie.pojo;

import java.io.Serializable;

public class EventsWaitsHistoryLong implements Serializable {
    private Long threadId;

    private Long eventId;

    private Long endEventId;

    private String eventName;

    private String source;

    private Long timerStart;

    private Long timerEnd;

    private Long timerWait;

    private Integer spins;

    private String objectSchema;

    private String objectName;

    private String indexName;

    private String objectType;

    private Long objectInstanceBegin;

    private Long nestingEventId;

    private String nestingEventType;

    private String operation;

    private Long numberOfBytes;

    private Integer flags;

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

    public Integer getSpins() {
        return spins;
    }

    public void setSpins(Integer spins) {
        this.spins = spins;
    }

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

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType == null ? null : objectType.trim();
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public Long getNumberOfBytes() {
        return numberOfBytes;
    }

    public void setNumberOfBytes(Long numberOfBytes) {
        this.numberOfBytes = numberOfBytes;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
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
        sb.append(", source=").append(source);
        sb.append(", timerStart=").append(timerStart);
        sb.append(", timerEnd=").append(timerEnd);
        sb.append(", timerWait=").append(timerWait);
        sb.append(", spins=").append(spins);
        sb.append(", objectSchema=").append(objectSchema);
        sb.append(", objectName=").append(objectName);
        sb.append(", indexName=").append(indexName);
        sb.append(", objectType=").append(objectType);
        sb.append(", objectInstanceBegin=").append(objectInstanceBegin);
        sb.append(", nestingEventId=").append(nestingEventId);
        sb.append(", nestingEventType=").append(nestingEventType);
        sb.append(", operation=").append(operation);
        sb.append(", numberOfBytes=").append(numberOfBytes);
        sb.append(", flags=").append(flags);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}