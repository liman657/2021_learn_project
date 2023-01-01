package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class Events implements Serializable {
    private String eventCatalog;

    private String eventSchema;

    private String eventName;

    private String definer;

    private String timeZone;

    private String eventBody;

    private String eventType;

    private Date executeAt;

    private String intervalValue;

    private String intervalField;

    private String sqlMode;

    private Date starts;

    private Date ends;

    private String status;

    private String onCompletion;

    private Date created;

    private Date lastAltered;

    private Date lastExecuted;

    private String eventComment;

    private Integer originator;

    private String characterSetClient;

    private String collationConnection;

    private String databaseCollation;

    private String eventDefinition;

    private static final long serialVersionUID = 1L;

    public String getEventCatalog() {
        return eventCatalog;
    }

    public void setEventCatalog(String eventCatalog) {
        this.eventCatalog = eventCatalog == null ? null : eventCatalog.trim();
    }

    public String getEventSchema() {
        return eventSchema;
    }

    public void setEventSchema(String eventSchema) {
        this.eventSchema = eventSchema == null ? null : eventSchema.trim();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public String getDefiner() {
        return definer;
    }

    public void setDefiner(String definer) {
        this.definer = definer == null ? null : definer.trim();
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone == null ? null : timeZone.trim();
    }

    public String getEventBody() {
        return eventBody;
    }

    public void setEventBody(String eventBody) {
        this.eventBody = eventBody == null ? null : eventBody.trim();
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType == null ? null : eventType.trim();
    }

    public Date getExecuteAt() {
        return executeAt;
    }

    public void setExecuteAt(Date executeAt) {
        this.executeAt = executeAt;
    }

    public String getIntervalValue() {
        return intervalValue;
    }

    public void setIntervalValue(String intervalValue) {
        this.intervalValue = intervalValue == null ? null : intervalValue.trim();
    }

    public String getIntervalField() {
        return intervalField;
    }

    public void setIntervalField(String intervalField) {
        this.intervalField = intervalField == null ? null : intervalField.trim();
    }

    public String getSqlMode() {
        return sqlMode;
    }

    public void setSqlMode(String sqlMode) {
        this.sqlMode = sqlMode == null ? null : sqlMode.trim();
    }

    public Date getStarts() {
        return starts;
    }

    public void setStarts(Date starts) {
        this.starts = starts;
    }

    public Date getEnds() {
        return ends;
    }

    public void setEnds(Date ends) {
        this.ends = ends;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOnCompletion() {
        return onCompletion;
    }

    public void setOnCompletion(String onCompletion) {
        this.onCompletion = onCompletion == null ? null : onCompletion.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastAltered() {
        return lastAltered;
    }

    public void setLastAltered(Date lastAltered) {
        this.lastAltered = lastAltered;
    }

    public Date getLastExecuted() {
        return lastExecuted;
    }

    public void setLastExecuted(Date lastExecuted) {
        this.lastExecuted = lastExecuted;
    }

    public String getEventComment() {
        return eventComment;
    }

    public void setEventComment(String eventComment) {
        this.eventComment = eventComment == null ? null : eventComment.trim();
    }

    public Integer getOriginator() {
        return originator;
    }

    public void setOriginator(Integer originator) {
        this.originator = originator;
    }

    public String getCharacterSetClient() {
        return characterSetClient;
    }

    public void setCharacterSetClient(String characterSetClient) {
        this.characterSetClient = characterSetClient == null ? null : characterSetClient.trim();
    }

    public String getCollationConnection() {
        return collationConnection;
    }

    public void setCollationConnection(String collationConnection) {
        this.collationConnection = collationConnection == null ? null : collationConnection.trim();
    }

    public String getDatabaseCollation() {
        return databaseCollation;
    }

    public void setDatabaseCollation(String databaseCollation) {
        this.databaseCollation = databaseCollation == null ? null : databaseCollation.trim();
    }

    public String getEventDefinition() {
        return eventDefinition;
    }

    public void setEventDefinition(String eventDefinition) {
        this.eventDefinition = eventDefinition == null ? null : eventDefinition.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eventCatalog=").append(eventCatalog);
        sb.append(", eventSchema=").append(eventSchema);
        sb.append(", eventName=").append(eventName);
        sb.append(", definer=").append(definer);
        sb.append(", timeZone=").append(timeZone);
        sb.append(", eventBody=").append(eventBody);
        sb.append(", eventType=").append(eventType);
        sb.append(", executeAt=").append(executeAt);
        sb.append(", intervalValue=").append(intervalValue);
        sb.append(", intervalField=").append(intervalField);
        sb.append(", sqlMode=").append(sqlMode);
        sb.append(", starts=").append(starts);
        sb.append(", ends=").append(ends);
        sb.append(", status=").append(status);
        sb.append(", onCompletion=").append(onCompletion);
        sb.append(", created=").append(created);
        sb.append(", lastAltered=").append(lastAltered);
        sb.append(", lastExecuted=").append(lastExecuted);
        sb.append(", eventComment=").append(eventComment);
        sb.append(", originator=").append(originator);
        sb.append(", characterSetClient=").append(characterSetClient);
        sb.append(", collationConnection=").append(collationConnection);
        sb.append(", databaseCollation=").append(databaseCollation);
        sb.append(", eventDefinition=").append(eventDefinition);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}