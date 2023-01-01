package com.coderman.foodie.pojo;

import java.io.Serializable;

public class ReplicationGroupMembers implements Serializable {
    private String channelName;

    private String memberId;

    private String memberHost;

    private Integer memberPort;

    private String memberState;

    private String memberRole;

    private String memberVersion;

    private String memberCommunicationStack;

    private static final long serialVersionUID = 1L;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getMemberHost() {
        return memberHost;
    }

    public void setMemberHost(String memberHost) {
        this.memberHost = memberHost == null ? null : memberHost.trim();
    }

    public Integer getMemberPort() {
        return memberPort;
    }

    public void setMemberPort(Integer memberPort) {
        this.memberPort = memberPort;
    }

    public String getMemberState() {
        return memberState;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState == null ? null : memberState.trim();
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole == null ? null : memberRole.trim();
    }

    public String getMemberVersion() {
        return memberVersion;
    }

    public void setMemberVersion(String memberVersion) {
        this.memberVersion = memberVersion == null ? null : memberVersion.trim();
    }

    public String getMemberCommunicationStack() {
        return memberCommunicationStack;
    }

    public void setMemberCommunicationStack(String memberCommunicationStack) {
        this.memberCommunicationStack = memberCommunicationStack == null ? null : memberCommunicationStack.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", channelName=").append(channelName);
        sb.append(", memberId=").append(memberId);
        sb.append(", memberHost=").append(memberHost);
        sb.append(", memberPort=").append(memberPort);
        sb.append(", memberState=").append(memberState);
        sb.append(", memberRole=").append(memberRole);
        sb.append(", memberVersion=").append(memberVersion);
        sb.append(", memberCommunicationStack=").append(memberCommunicationStack);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}