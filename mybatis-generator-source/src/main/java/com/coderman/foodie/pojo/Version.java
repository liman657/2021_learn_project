package com.coderman.foodie.pojo;

import java.io.Serializable;

public class Version implements Serializable {
    private String sysVersion;

    private String mysqlVersion;

    private static final long serialVersionUID = 1L;

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion == null ? null : sysVersion.trim();
    }

    public String getMysqlVersion() {
        return mysqlVersion;
    }

    public void setMysqlVersion(String mysqlVersion) {
        this.mysqlVersion = mysqlVersion == null ? null : mysqlVersion.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sysVersion=").append(sysVersion);
        sb.append(", mysqlVersion=").append(mysqlVersion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}