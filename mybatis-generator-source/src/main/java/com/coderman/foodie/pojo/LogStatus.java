package com.coderman.foodie.pojo;

import java.io.Serializable;

public class LogStatus implements Serializable {
    private String serverUuid;

    private String local;

    private String replication;

    private String storageEngines;

    private static final long serialVersionUID = 1L;

    public String getServerUuid() {
        return serverUuid;
    }

    public void setServerUuid(String serverUuid) {
        this.serverUuid = serverUuid == null ? null : serverUuid.trim();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local == null ? null : local.trim();
    }

    public String getReplication() {
        return replication;
    }

    public void setReplication(String replication) {
        this.replication = replication == null ? null : replication.trim();
    }

    public String getStorageEngines() {
        return storageEngines;
    }

    public void setStorageEngines(String storageEngines) {
        this.storageEngines = storageEngines == null ? null : storageEngines.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serverUuid=").append(serverUuid);
        sb.append(", local=").append(local);
        sb.append(", replication=").append(replication);
        sb.append(", storageEngines=").append(storageEngines);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}