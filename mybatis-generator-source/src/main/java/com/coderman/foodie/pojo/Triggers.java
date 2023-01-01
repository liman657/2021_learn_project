package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class Triggers implements Serializable {
    private String triggerCatalog;

    private String triggerSchema;

    private String triggerName;

    private String eventManipulation;

    private String eventObjectCatalog;

    private String eventObjectSchema;

    private String eventObjectTable;

    private Integer actionOrder;

    private String actionOrientation;

    private String actionTiming;

    private String actionReferenceOldRow;

    private String actionReferenceNewRow;

    private Date created;

    private String sqlMode;

    private String definer;

    private String characterSetClient;

    private String collationConnection;

    private String databaseCollation;

    private byte[] actionCondition;

    private String actionStatement;

    private byte[] actionReferenceOldTable;

    private byte[] actionReferenceNewTable;

    private static final long serialVersionUID = 1L;

    public String getTriggerCatalog() {
        return triggerCatalog;
    }

    public void setTriggerCatalog(String triggerCatalog) {
        this.triggerCatalog = triggerCatalog == null ? null : triggerCatalog.trim();
    }

    public String getTriggerSchema() {
        return triggerSchema;
    }

    public void setTriggerSchema(String triggerSchema) {
        this.triggerSchema = triggerSchema == null ? null : triggerSchema.trim();
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName == null ? null : triggerName.trim();
    }

    public String getEventManipulation() {
        return eventManipulation;
    }

    public void setEventManipulation(String eventManipulation) {
        this.eventManipulation = eventManipulation == null ? null : eventManipulation.trim();
    }

    public String getEventObjectCatalog() {
        return eventObjectCatalog;
    }

    public void setEventObjectCatalog(String eventObjectCatalog) {
        this.eventObjectCatalog = eventObjectCatalog == null ? null : eventObjectCatalog.trim();
    }

    public String getEventObjectSchema() {
        return eventObjectSchema;
    }

    public void setEventObjectSchema(String eventObjectSchema) {
        this.eventObjectSchema = eventObjectSchema == null ? null : eventObjectSchema.trim();
    }

    public String getEventObjectTable() {
        return eventObjectTable;
    }

    public void setEventObjectTable(String eventObjectTable) {
        this.eventObjectTable = eventObjectTable == null ? null : eventObjectTable.trim();
    }

    public Integer getActionOrder() {
        return actionOrder;
    }

    public void setActionOrder(Integer actionOrder) {
        this.actionOrder = actionOrder;
    }

    public String getActionOrientation() {
        return actionOrientation;
    }

    public void setActionOrientation(String actionOrientation) {
        this.actionOrientation = actionOrientation == null ? null : actionOrientation.trim();
    }

    public String getActionTiming() {
        return actionTiming;
    }

    public void setActionTiming(String actionTiming) {
        this.actionTiming = actionTiming == null ? null : actionTiming.trim();
    }

    public String getActionReferenceOldRow() {
        return actionReferenceOldRow;
    }

    public void setActionReferenceOldRow(String actionReferenceOldRow) {
        this.actionReferenceOldRow = actionReferenceOldRow == null ? null : actionReferenceOldRow.trim();
    }

    public String getActionReferenceNewRow() {
        return actionReferenceNewRow;
    }

    public void setActionReferenceNewRow(String actionReferenceNewRow) {
        this.actionReferenceNewRow = actionReferenceNewRow == null ? null : actionReferenceNewRow.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSqlMode() {
        return sqlMode;
    }

    public void setSqlMode(String sqlMode) {
        this.sqlMode = sqlMode == null ? null : sqlMode.trim();
    }

    public String getDefiner() {
        return definer;
    }

    public void setDefiner(String definer) {
        this.definer = definer == null ? null : definer.trim();
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

    public byte[] getActionCondition() {
        return actionCondition;
    }

    public void setActionCondition(byte[] actionCondition) {
        this.actionCondition = actionCondition;
    }

    public String getActionStatement() {
        return actionStatement;
    }

    public void setActionStatement(String actionStatement) {
        this.actionStatement = actionStatement == null ? null : actionStatement.trim();
    }

    public byte[] getActionReferenceOldTable() {
        return actionReferenceOldTable;
    }

    public void setActionReferenceOldTable(byte[] actionReferenceOldTable) {
        this.actionReferenceOldTable = actionReferenceOldTable;
    }

    public byte[] getActionReferenceNewTable() {
        return actionReferenceNewTable;
    }

    public void setActionReferenceNewTable(byte[] actionReferenceNewTable) {
        this.actionReferenceNewTable = actionReferenceNewTable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", triggerCatalog=").append(triggerCatalog);
        sb.append(", triggerSchema=").append(triggerSchema);
        sb.append(", triggerName=").append(triggerName);
        sb.append(", eventManipulation=").append(eventManipulation);
        sb.append(", eventObjectCatalog=").append(eventObjectCatalog);
        sb.append(", eventObjectSchema=").append(eventObjectSchema);
        sb.append(", eventObjectTable=").append(eventObjectTable);
        sb.append(", actionOrder=").append(actionOrder);
        sb.append(", actionOrientation=").append(actionOrientation);
        sb.append(", actionTiming=").append(actionTiming);
        sb.append(", actionReferenceOldRow=").append(actionReferenceOldRow);
        sb.append(", actionReferenceNewRow=").append(actionReferenceNewRow);
        sb.append(", created=").append(created);
        sb.append(", sqlMode=").append(sqlMode);
        sb.append(", definer=").append(definer);
        sb.append(", characterSetClient=").append(characterSetClient);
        sb.append(", collationConnection=").append(collationConnection);
        sb.append(", databaseCollation=").append(databaseCollation);
        sb.append(", actionCondition=").append(actionCondition);
        sb.append(", actionStatement=").append(actionStatement);
        sb.append(", actionReferenceOldTable=").append(actionReferenceOldTable);
        sb.append(", actionReferenceNewTable=").append(actionReferenceNewTable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}