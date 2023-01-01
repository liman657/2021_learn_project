package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ServerCost implements Serializable {
    private String costName;

    private Float costValue;

    private Date lastUpdate;

    private String comment;

    private Float defaultValue;

    private static final long serialVersionUID = 1L;

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName == null ? null : costName.trim();
    }

    public Float getCostValue() {
        return costValue;
    }

    public void setCostValue(Float costValue) {
        this.costValue = costValue;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Float getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Float defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", costName=").append(costName);
        sb.append(", costValue=").append(costValue);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", comment=").append(comment);
        sb.append(", defaultValue=").append(defaultValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}