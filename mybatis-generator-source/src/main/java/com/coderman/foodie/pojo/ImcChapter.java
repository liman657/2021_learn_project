package com.coderman.foodie.pojo;

import java.io.Serializable;

public class ImcChapter implements Serializable {
    private Integer chapterId;

    private Integer courseId;

    private String chapterName;

    private String chapterInfo;

    private Byte chapterNo;

    private static final long serialVersionUID = 1L;

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

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public String getChapterInfo() {
        return chapterInfo;
    }

    public void setChapterInfo(String chapterInfo) {
        this.chapterInfo = chapterInfo == null ? null : chapterInfo.trim();
    }

    public Byte getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(Byte chapterNo) {
        this.chapterNo = chapterNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chapterId=").append(chapterId);
        sb.append(", courseId=").append(courseId);
        sb.append(", chapterName=").append(chapterName);
        sb.append(", chapterInfo=").append(chapterInfo);
        sb.append(", chapterNo=").append(chapterNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}