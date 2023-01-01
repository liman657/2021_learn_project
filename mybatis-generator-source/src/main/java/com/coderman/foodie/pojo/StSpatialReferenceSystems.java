package com.coderman.foodie.pojo;

import java.io.Serializable;

public class StSpatialReferenceSystems implements Serializable {
    private String srsName;

    private Integer srsId;

    private String organization;

    private Integer organizationCoordsysId;

    private String definition;

    private String description;

    private static final long serialVersionUID = 1L;

    public String getSrsName() {
        return srsName;
    }

    public void setSrsName(String srsName) {
        this.srsName = srsName == null ? null : srsName.trim();
    }

    public Integer getSrsId() {
        return srsId;
    }

    public void setSrsId(Integer srsId) {
        this.srsId = srsId;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public Integer getOrganizationCoordsysId() {
        return organizationCoordsysId;
    }

    public void setOrganizationCoordsysId(Integer organizationCoordsysId) {
        this.organizationCoordsysId = organizationCoordsysId;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition == null ? null : definition.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srsName=").append(srsName);
        sb.append(", srsId=").append(srsId);
        sb.append(", organization=").append(organization);
        sb.append(", organizationCoordsysId=").append(organizationCoordsysId);
        sb.append(", definition=").append(definition);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}