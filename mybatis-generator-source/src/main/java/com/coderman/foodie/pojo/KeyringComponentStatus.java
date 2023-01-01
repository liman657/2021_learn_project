package com.coderman.foodie.pojo;

import java.io.Serializable;

public class KeyringComponentStatus implements Serializable {
    private String statusKey;

    private String statusValue;

    private static final long serialVersionUID = 1L;

    public String getStatusKey() {
        return statusKey;
    }

    public void setStatusKey(String statusKey) {
        this.statusKey = statusKey == null ? null : statusKey.trim();
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue == null ? null : statusValue.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", statusKey=").append(statusKey);
        sb.append(", statusValue=").append(statusValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}