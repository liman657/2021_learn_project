package com.coderman.foodie.pojo;

import java.io.Serializable;

public class EnabledRoles implements Serializable {
    private String roleName;

    private String roleHost;

    private String isDefault;

    private String isMandatory;

    private static final long serialVersionUID = 1L;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleHost() {
        return roleHost;
    }

    public void setRoleHost(String roleHost) {
        this.roleHost = roleHost == null ? null : roleHost.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public String getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(String isMandatory) {
        this.isMandatory = isMandatory == null ? null : isMandatory.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleName=").append(roleName);
        sb.append(", roleHost=").append(roleHost);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", isMandatory=").append(isMandatory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}