package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Tablespaces implements Serializable {
    private String tablespaceName;

    private String engine;

    private String tablespaceType;

    private String logfileGroupName;

    private Long extentSize;

    private Long autoextendSize;

    private Long maximumSize;

    private Long nodegroupId;

    private String tablespaceComment;

    private static final long serialVersionUID = 1L;

    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName == null ? null : tablespaceName.trim();
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getTablespaceType() {
        return tablespaceType;
    }

    public void setTablespaceType(String tablespaceType) {
        this.tablespaceType = tablespaceType == null ? null : tablespaceType.trim();
    }

    public String getLogfileGroupName() {
        return logfileGroupName;
    }

    public void setLogfileGroupName(String logfileGroupName) {
        this.logfileGroupName = logfileGroupName == null ? null : logfileGroupName.trim();
    }

    public Long getExtentSize() {
        return extentSize;
    }

    public void setExtentSize(Long extentSize) {
        this.extentSize = extentSize;
    }

    public Long getAutoextendSize() {
        return autoextendSize;
    }

    public void setAutoextendSize(Long autoextendSize) {
        this.autoextendSize = autoextendSize;
    }

    public Long getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(Long maximumSize) {
        this.maximumSize = maximumSize;
    }

    public Long getNodegroupId() {
        return nodegroupId;
    }

    public void setNodegroupId(Long nodegroupId) {
        this.nodegroupId = nodegroupId;
    }

    public String getTablespaceComment() {
        return tablespaceComment;
    }

    public void setTablespaceComment(String tablespaceComment) {
        this.tablespaceComment = tablespaceComment == null ? null : tablespaceComment.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tablespaceName=").append(tablespaceName);
        sb.append(", engine=").append(engine);
        sb.append(", tablespaceType=").append(tablespaceType);
        sb.append(", logfileGroupName=").append(logfileGroupName);
        sb.append(", extentSize=").append(extentSize);
        sb.append(", autoextendSize=").append(autoextendSize);
        sb.append(", maximumSize=").append(maximumSize);
        sb.append(", nodegroupId=").append(nodegroupId);
        sb.append(", tablespaceComment=").append(tablespaceComment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}