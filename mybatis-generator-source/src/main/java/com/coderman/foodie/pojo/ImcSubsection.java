package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ImcSubsection implements Serializable {
    private Integer subId;

    private Integer chapterId;

    private Integer courseId;

    private String subName;

    private String subUrl;

    private String videoType;

    private Date subTime;

    private Byte subNo;

    private static final long serialVersionUID = 1L;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public String getSubUrl() {
        return subUrl;
    }

    public void setSubUrl(String subUrl) {
        this.subUrl = subUrl == null ? null : subUrl.trim();
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType == null ? null : videoType.trim();
    }

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public Byte getSubNo() {
        return subNo;
    }

    public void setSubNo(Byte subNo) {
        this.subNo = subNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", subId=").append(subId);
        sb.append(", chapterId=").append(chapterId);
        sb.append(", courseId=").append(courseId);
        sb.append(", subName=").append(subName);
        sb.append(", subUrl=").append(subUrl);
        sb.append(", videoType=").append(videoType);
        sb.append(", subTime=").append(subTime);
        sb.append(", subNo=").append(subNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}