package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Plugins implements Serializable {
    private String pluginName;

    private String pluginVersion;

    private String pluginStatus;

    private String pluginType;

    private String pluginTypeVersion;

    private String pluginLibrary;

    private String pluginLibraryVersion;

    private String pluginAuthor;

    private String pluginDescription;

    private String pluginLicense;

    private String loadOption;

    private static final long serialVersionUID = 1L;

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName == null ? null : pluginName.trim();
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion == null ? null : pluginVersion.trim();
    }

    public String getPluginStatus() {
        return pluginStatus;
    }

    public void setPluginStatus(String pluginStatus) {
        this.pluginStatus = pluginStatus == null ? null : pluginStatus.trim();
    }

    public String getPluginType() {
        return pluginType;
    }

    public void setPluginType(String pluginType) {
        this.pluginType = pluginType == null ? null : pluginType.trim();
    }

    public String getPluginTypeVersion() {
        return pluginTypeVersion;
    }

    public void setPluginTypeVersion(String pluginTypeVersion) {
        this.pluginTypeVersion = pluginTypeVersion == null ? null : pluginTypeVersion.trim();
    }

    public String getPluginLibrary() {
        return pluginLibrary;
    }

    public void setPluginLibrary(String pluginLibrary) {
        this.pluginLibrary = pluginLibrary == null ? null : pluginLibrary.trim();
    }

    public String getPluginLibraryVersion() {
        return pluginLibraryVersion;
    }

    public void setPluginLibraryVersion(String pluginLibraryVersion) {
        this.pluginLibraryVersion = pluginLibraryVersion == null ? null : pluginLibraryVersion.trim();
    }

    public String getPluginAuthor() {
        return pluginAuthor;
    }

    public void setPluginAuthor(String pluginAuthor) {
        this.pluginAuthor = pluginAuthor == null ? null : pluginAuthor.trim();
    }

    public String getPluginDescription() {
        return pluginDescription;
    }

    public void setPluginDescription(String pluginDescription) {
        this.pluginDescription = pluginDescription == null ? null : pluginDescription.trim();
    }

    public String getPluginLicense() {
        return pluginLicense;
    }

    public void setPluginLicense(String pluginLicense) {
        this.pluginLicense = pluginLicense == null ? null : pluginLicense.trim();
    }

    public String getLoadOption() {
        return loadOption;
    }

    public void setLoadOption(String loadOption) {
        this.loadOption = loadOption == null ? null : loadOption.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pluginName=").append(pluginName);
        sb.append(", pluginVersion=").append(pluginVersion);
        sb.append(", pluginStatus=").append(pluginStatus);
        sb.append(", pluginType=").append(pluginType);
        sb.append(", pluginTypeVersion=").append(pluginTypeVersion);
        sb.append(", pluginLibrary=").append(pluginLibrary);
        sb.append(", pluginLibraryVersion=").append(pluginLibraryVersion);
        sb.append(", pluginAuthor=").append(pluginAuthor);
        sb.append(", pluginDescription=").append(pluginDescription);
        sb.append(", pluginLicense=").append(pluginLicense);
        sb.append(", loadOption=").append(loadOption);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}