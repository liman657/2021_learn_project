package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class VariablesInfo implements Serializable {
    private String variableName;

    private String variableSource;

    private String variablePath;

    private String minValue;

    private String maxValue;

    private Date setTime;

    private String setUser;

    private String setHost;

    private static final long serialVersionUID = 1L;

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName == null ? null : variableName.trim();
    }

    public String getVariableSource() {
        return variableSource;
    }

    public void setVariableSource(String variableSource) {
        this.variableSource = variableSource == null ? null : variableSource.trim();
    }

    public String getVariablePath() {
        return variablePath;
    }

    public void setVariablePath(String variablePath) {
        this.variablePath = variablePath == null ? null : variablePath.trim();
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue == null ? null : minValue.trim();
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue == null ? null : maxValue.trim();
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    public String getSetUser() {
        return setUser;
    }

    public void setSetUser(String setUser) {
        this.setUser = setUser == null ? null : setUser.trim();
    }

    public String getSetHost() {
        return setHost;
    }

    public void setSetHost(String setHost) {
        this.setHost = setHost == null ? null : setHost.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", variableName=").append(variableName);
        sb.append(", variableSource=").append(variableSource);
        sb.append(", variablePath=").append(variablePath);
        sb.append(", minValue=").append(minValue);
        sb.append(", maxValue=").append(maxValue);
        sb.append(", setTime=").append(setTime);
        sb.append(", setUser=").append(setUser);
        sb.append(", setHost=").append(setHost);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}