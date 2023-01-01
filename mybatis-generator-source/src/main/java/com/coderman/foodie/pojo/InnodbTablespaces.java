package com.coderman.foodie.pojo;

import java.io.Serializable;

public class InnodbTablespaces implements Serializable {
    private Integer space;

    private String name;

    private Integer flag;

    private String rowFormat;

    private Integer pageSize;

    private Integer zipPageSize;

    private String spaceType;

    private Integer fsBlockSize;

    private Long fileSize;

    private Long allocatedSize;

    private Long autoextendSize;

    private String serverVersion;

    private Integer spaceVersion;

    private String encryption;

    private String state;

    private static final long serialVersionUID = 1L;

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat == null ? null : rowFormat.trim();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getZipPageSize() {
        return zipPageSize;
    }

    public void setZipPageSize(Integer zipPageSize) {
        this.zipPageSize = zipPageSize;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType == null ? null : spaceType.trim();
    }

    public Integer getFsBlockSize() {
        return fsBlockSize;
    }

    public void setFsBlockSize(Integer fsBlockSize) {
        this.fsBlockSize = fsBlockSize;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getAllocatedSize() {
        return allocatedSize;
    }

    public void setAllocatedSize(Long allocatedSize) {
        this.allocatedSize = allocatedSize;
    }

    public Long getAutoextendSize() {
        return autoextendSize;
    }

    public void setAutoextendSize(Long autoextendSize) {
        this.autoextendSize = autoextendSize;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion == null ? null : serverVersion.trim();
    }

    public Integer getSpaceVersion() {
        return spaceVersion;
    }

    public void setSpaceVersion(Integer spaceVersion) {
        this.spaceVersion = spaceVersion;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption == null ? null : encryption.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", space=").append(space);
        sb.append(", name=").append(name);
        sb.append(", flag=").append(flag);
        sb.append(", rowFormat=").append(rowFormat);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", zipPageSize=").append(zipPageSize);
        sb.append(", spaceType=").append(spaceType);
        sb.append(", fsBlockSize=").append(fsBlockSize);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", allocatedSize=").append(allocatedSize);
        sb.append(", autoextendSize=").append(autoextendSize);
        sb.append(", serverVersion=").append(serverVersion);
        sb.append(", spaceVersion=").append(spaceVersion);
        sb.append(", encryption=").append(encryption);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}