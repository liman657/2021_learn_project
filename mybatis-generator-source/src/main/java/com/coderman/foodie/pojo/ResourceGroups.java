package com.coderman.foodie.pojo;

import java.io.Serializable;

public class ResourceGroups implements Serializable {
    private String resourceGroupName;

    private String resourceGroupType;

    private Boolean resourceGroupEnabled;

    private Integer threadPriority;

    private byte[] vcpuIds;

    private static final long serialVersionUID = 1L;

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName == null ? null : resourceGroupName.trim();
    }

    public String getResourceGroupType() {
        return resourceGroupType;
    }

    public void setResourceGroupType(String resourceGroupType) {
        this.resourceGroupType = resourceGroupType == null ? null : resourceGroupType.trim();
    }

    public Boolean getResourceGroupEnabled() {
        return resourceGroupEnabled;
    }

    public void setResourceGroupEnabled(Boolean resourceGroupEnabled) {
        this.resourceGroupEnabled = resourceGroupEnabled;
    }

    public Integer getThreadPriority() {
        return threadPriority;
    }

    public void setThreadPriority(Integer threadPriority) {
        this.threadPriority = threadPriority;
    }

    public byte[] getVcpuIds() {
        return vcpuIds;
    }

    public void setVcpuIds(byte[] vcpuIds) {
        this.vcpuIds = vcpuIds;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourceGroupName=").append(resourceGroupName);
        sb.append(", resourceGroupType=").append(resourceGroupType);
        sb.append(", resourceGroupEnabled=").append(resourceGroupEnabled);
        sb.append(", threadPriority=").append(threadPriority);
        sb.append(", vcpuIds=").append(vcpuIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}