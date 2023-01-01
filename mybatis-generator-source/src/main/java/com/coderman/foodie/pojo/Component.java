package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Component implements Serializable {
    private Integer componentId;

    private Integer componentGroupId;

    private String componentUrn;

    private static final long serialVersionUID = 1L;

    public Integer getComponentId() {
        return componentId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public Integer getComponentGroupId() {
        return componentGroupId;
    }

    public void setComponentGroupId(Integer componentGroupId) {
        this.componentGroupId = componentGroupId;
    }

    public String getComponentUrn() {
        return componentUrn;
    }

    public void setComponentUrn(String componentUrn) {
        this.componentUrn = componentUrn == null ? null : componentUrn.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", componentId=").append(componentId);
        sb.append(", componentGroupId=").append(componentGroupId);
        sb.append(", componentUrn=").append(componentUrn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}