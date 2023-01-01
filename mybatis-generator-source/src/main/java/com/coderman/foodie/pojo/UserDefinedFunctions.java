package com.coderman.foodie.pojo;

import java.io.Serializable;

public class UserDefinedFunctions implements Serializable {
    private String udfName;

    private String udfReturnType;

    private String udfType;

    private String udfLibrary;

    private Long udfUsageCount;

    private static final long serialVersionUID = 1L;

    public String getUdfName() {
        return udfName;
    }

    public void setUdfName(String udfName) {
        this.udfName = udfName == null ? null : udfName.trim();
    }

    public String getUdfReturnType() {
        return udfReturnType;
    }

    public void setUdfReturnType(String udfReturnType) {
        this.udfReturnType = udfReturnType == null ? null : udfReturnType.trim();
    }

    public String getUdfType() {
        return udfType;
    }

    public void setUdfType(String udfType) {
        this.udfType = udfType == null ? null : udfType.trim();
    }

    public String getUdfLibrary() {
        return udfLibrary;
    }

    public void setUdfLibrary(String udfLibrary) {
        this.udfLibrary = udfLibrary == null ? null : udfLibrary.trim();
    }

    public Long getUdfUsageCount() {
        return udfUsageCount;
    }

    public void setUdfUsageCount(Long udfUsageCount) {
        this.udfUsageCount = udfUsageCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", udfName=").append(udfName);
        sb.append(", udfReturnType=").append(udfReturnType);
        sb.append(", udfType=").append(udfType);
        sb.append(", udfLibrary=").append(udfLibrary);
        sb.append(", udfUsageCount=").append(udfUsageCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}