package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class Routines implements Serializable {
    private String specificName;

    private String routineCatalog;

    private String routineSchema;

    private String routineName;

    private String routineType;

    private Long characterMaximumLength;

    private Long characterOctetLength;

    private Integer numericPrecision;

    private Integer numericScale;

    private Integer datetimePrecision;

    private String characterSetName;

    private String collationName;

    private String routineBody;

    private String externalLanguage;

    private String parameterStyle;

    private String isDeterministic;

    private String sqlDataAccess;

    private String securityType;

    private Date created;

    private Date lastAltered;

    private String sqlMode;

    private String definer;

    private String characterSetClient;

    private String collationConnection;

    private String databaseCollation;

    private String dataType;

    private String dtdIdentifier;

    private String routineDefinition;

    private byte[] externalName;

    private byte[] sqlPath;

    private String routineComment;

    private static final long serialVersionUID = 1L;

    public String getSpecificName() {
        return specificName;
    }

    public void setSpecificName(String specificName) {
        this.specificName = specificName == null ? null : specificName.trim();
    }

    public String getRoutineCatalog() {
        return routineCatalog;
    }

    public void setRoutineCatalog(String routineCatalog) {
        this.routineCatalog = routineCatalog == null ? null : routineCatalog.trim();
    }

    public String getRoutineSchema() {
        return routineSchema;
    }

    public void setRoutineSchema(String routineSchema) {
        this.routineSchema = routineSchema == null ? null : routineSchema.trim();
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName == null ? null : routineName.trim();
    }

    public String getRoutineType() {
        return routineType;
    }

    public void setRoutineType(String routineType) {
        this.routineType = routineType == null ? null : routineType.trim();
    }

    public Long getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(Long characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public Long getCharacterOctetLength() {
        return characterOctetLength;
    }

    public void setCharacterOctetLength(Long characterOctetLength) {
        this.characterOctetLength = characterOctetLength;
    }

    public Integer getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(Integer numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public Integer getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(Integer numericScale) {
        this.numericScale = numericScale;
    }

    public Integer getDatetimePrecision() {
        return datetimePrecision;
    }

    public void setDatetimePrecision(Integer datetimePrecision) {
        this.datetimePrecision = datetimePrecision;
    }

    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName == null ? null : characterSetName.trim();
    }

    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName == null ? null : collationName.trim();
    }

    public String getRoutineBody() {
        return routineBody;
    }

    public void setRoutineBody(String routineBody) {
        this.routineBody = routineBody == null ? null : routineBody.trim();
    }

    public String getExternalLanguage() {
        return externalLanguage;
    }

    public void setExternalLanguage(String externalLanguage) {
        this.externalLanguage = externalLanguage == null ? null : externalLanguage.trim();
    }

    public String getParameterStyle() {
        return parameterStyle;
    }

    public void setParameterStyle(String parameterStyle) {
        this.parameterStyle = parameterStyle == null ? null : parameterStyle.trim();
    }

    public String getIsDeterministic() {
        return isDeterministic;
    }

    public void setIsDeterministic(String isDeterministic) {
        this.isDeterministic = isDeterministic == null ? null : isDeterministic.trim();
    }

    public String getSqlDataAccess() {
        return sqlDataAccess;
    }

    public void setSqlDataAccess(String sqlDataAccess) {
        this.sqlDataAccess = sqlDataAccess == null ? null : sqlDataAccess.trim();
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType == null ? null : securityType.trim();
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getDtdIdentifier() {
        return dtdIdentifier;
    }

    public void setDtdIdentifier(String dtdIdentifier) {
        this.dtdIdentifier = dtdIdentifier == null ? null : dtdIdentifier.trim();
    }

    public String getRoutineDefinition() {
        return routineDefinition;
    }

    public void setRoutineDefinition(String routineDefinition) {
        this.routineDefinition = routineDefinition == null ? null : routineDefinition.trim();
    }

    public byte[] getExternalName() {
        return externalName;
    }

    public void setExternalName(byte[] externalName) {
        this.externalName = externalName;
    }

    public byte[] getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(byte[] sqlPath) {
        this.sqlPath = sqlPath;
    }

    public String getRoutineComment() {
        return routineComment;
    }

    public void setRoutineComment(String routineComment) {
        this.routineComment = routineComment == null ? null : routineComment.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", specificName=").append(specificName);
        sb.append(", routineCatalog=").append(routineCatalog);
        sb.append(", routineSchema=").append(routineSchema);
        sb.append(", routineName=").append(routineName);
        sb.append(", routineType=").append(routineType);
        sb.append(", characterMaximumLength=").append(characterMaximumLength);
        sb.append(", characterOctetLength=").append(characterOctetLength);
        sb.append(", numericPrecision=").append(numericPrecision);
        sb.append(", numericScale=").append(numericScale);
        sb.append(", datetimePrecision=").append(datetimePrecision);
        sb.append(", characterSetName=").append(characterSetName);
        sb.append(", collationName=").append(collationName);
        sb.append(", routineBody=").append(routineBody);
        sb.append(", externalLanguage=").append(externalLanguage);
        sb.append(", parameterStyle=").append(parameterStyle);
        sb.append(", isDeterministic=").append(isDeterministic);
        sb.append(", sqlDataAccess=").append(sqlDataAccess);
        sb.append(", securityType=").append(securityType);
        sb.append(", created=").append(created);
        sb.append(", lastAltered=").append(lastAltered);
        sb.append(", sqlMode=").append(sqlMode);
        sb.append(", definer=").append(definer);
        sb.append(", characterSetClient=").append(characterSetClient);
        sb.append(", collationConnection=").append(collationConnection);
        sb.append(", databaseCollation=").append(databaseCollation);
        sb.append(", dataType=").append(dataType);
        sb.append(", dtdIdentifier=").append(dtdIdentifier);
        sb.append(", routineDefinition=").append(routineDefinition);
        sb.append(", externalName=").append(externalName);
        sb.append(", sqlPath=").append(sqlPath);
        sb.append(", routineComment=").append(routineComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}