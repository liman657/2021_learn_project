package com.coderman.foodie.pojo;

import java.io.Serializable;

public class SlaveWorkerInfo implements Serializable {
    private String channelName;

    private Integer id;

    private Long relayLogPos;

    private Long masterLogPos;

    private Long checkpointRelayLogPos;

    private Long checkpointMasterLogPos;

    private Integer checkpointSeqno;

    private Integer checkpointGroupSize;

    private String relayLogName;

    private String masterLogName;

    private String checkpointRelayLogName;

    private String checkpointMasterLogName;

    private byte[] checkpointGroupBitmap;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRelayLogPos() {
        return relayLogPos;
    }

    public void setRelayLogPos(Long relayLogPos) {
        this.relayLogPos = relayLogPos;
    }

    public Long getMasterLogPos() {
        return masterLogPos;
    }

    public void setMasterLogPos(Long masterLogPos) {
        this.masterLogPos = masterLogPos;
    }

    public Long getCheckpointRelayLogPos() {
        return checkpointRelayLogPos;
    }

    public void setCheckpointRelayLogPos(Long checkpointRelayLogPos) {
        this.checkpointRelayLogPos = checkpointRelayLogPos;
    }

    public Long getCheckpointMasterLogPos() {
        return checkpointMasterLogPos;
    }

    public void setCheckpointMasterLogPos(Long checkpointMasterLogPos) {
        this.checkpointMasterLogPos = checkpointMasterLogPos;
    }

    public Integer getCheckpointSeqno() {
        return checkpointSeqno;
    }

    public void setCheckpointSeqno(Integer checkpointSeqno) {
        this.checkpointSeqno = checkpointSeqno;
    }

    public Integer getCheckpointGroupSize() {
        return checkpointGroupSize;
    }

    public void setCheckpointGroupSize(Integer checkpointGroupSize) {
        this.checkpointGroupSize = checkpointGroupSize;
    }

    public String getRelayLogName() {
        return relayLogName;
    }

    public void setRelayLogName(String relayLogName) {
        this.relayLogName = relayLogName == null ? null : relayLogName.trim();
    }

    public String getMasterLogName() {
        return masterLogName;
    }

    public void setMasterLogName(String masterLogName) {
        this.masterLogName = masterLogName == null ? null : masterLogName.trim();
    }

    public String getCheckpointRelayLogName() {
        return checkpointRelayLogName;
    }

    public void setCheckpointRelayLogName(String checkpointRelayLogName) {
        this.checkpointRelayLogName = checkpointRelayLogName == null ? null : checkpointRelayLogName.trim();
    }

    public String getCheckpointMasterLogName() {
        return checkpointMasterLogName;
    }

    public void setCheckpointMasterLogName(String checkpointMasterLogName) {
        this.checkpointMasterLogName = checkpointMasterLogName == null ? null : checkpointMasterLogName.trim();
    }

    public byte[] getCheckpointGroupBitmap() {
        return checkpointGroupBitmap;
    }

    public void setCheckpointGroupBitmap(byte[] checkpointGroupBitmap) {
        this.checkpointGroupBitmap = checkpointGroupBitmap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", id=").append(id);
        sb.append(", relayLogPos=").append(relayLogPos);
        sb.append(", masterLogPos=").append(masterLogPos);
        sb.append(", checkpointRelayLogPos=").append(checkpointRelayLogPos);
        sb.append(", checkpointMasterLogPos=").append(checkpointMasterLogPos);
        sb.append(", checkpointSeqno=").append(checkpointSeqno);
        sb.append(", checkpointGroupSize=").append(checkpointGroupSize);
        sb.append(", relayLogName=").append(relayLogName);
        sb.append(", masterLogName=").append(masterLogName);
        sb.append(", checkpointRelayLogName=").append(checkpointRelayLogName);
        sb.append(", checkpointMasterLogName=").append(checkpointMasterLogName);
        sb.append(", checkpointGroupBitmap=").append(checkpointGroupBitmap);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}