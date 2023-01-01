package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ImcCourse implements Serializable {
    private Integer courseId;

    private String title;

    private String titleDesc;

    private Short typeId;

    private Short classId;

    private Short levelId;

    private Date onlineTime;

    private Integer studyCnt;

    private Date courseTime;

    private String intro;

    private String info;

    private String harvest;

    private Integer userId;

    private String mainPic;

    private BigDecimal contentScore;

    private BigDecimal levelScore;

    private BigDecimal logicScore;

    private BigDecimal score;

    private static final long serialVersionUID = 1L;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc == null ? null : titleDesc.trim();
    }

    public Short getTypeId() {
        return typeId;
    }

    public void setTypeId(Short typeId) {
        this.typeId = typeId;
    }

    public Short getClassId() {
        return classId;
    }

    public void setClassId(Short classId) {
        this.classId = classId;
    }

    public Short getLevelId() {
        return levelId;
    }

    public void setLevelId(Short levelId) {
        this.levelId = levelId;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Integer getStudyCnt() {
        return studyCnt;
    }

    public void setStudyCnt(Integer studyCnt) {
        this.studyCnt = studyCnt;
    }

    public Date getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getHarvest() {
        return harvest;
    }

    public void setHarvest(String harvest) {
        this.harvest = harvest == null ? null : harvest.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic == null ? null : mainPic.trim();
    }

    public BigDecimal getContentScore() {
        return contentScore;
    }

    public void setContentScore(BigDecimal contentScore) {
        this.contentScore = contentScore;
    }

    public BigDecimal getLevelScore() {
        return levelScore;
    }

    public void setLevelScore(BigDecimal levelScore) {
        this.levelScore = levelScore;
    }

    public BigDecimal getLogicScore() {
        return logicScore;
    }

    public void setLogicScore(BigDecimal logicScore) {
        this.logicScore = logicScore;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseId=").append(courseId);
        sb.append(", title=").append(title);
        sb.append(", titleDesc=").append(titleDesc);
        sb.append(", typeId=").append(typeId);
        sb.append(", classId=").append(classId);
        sb.append(", levelId=").append(levelId);
        sb.append(", onlineTime=").append(onlineTime);
        sb.append(", studyCnt=").append(studyCnt);
        sb.append(", courseTime=").append(courseTime);
        sb.append(", intro=").append(intro);
        sb.append(", info=").append(info);
        sb.append(", harvest=").append(harvest);
        sb.append(", userId=").append(userId);
        sb.append(", mainPic=").append(mainPic);
        sb.append(", contentScore=").append(contentScore);
        sb.append(", levelScore=").append(levelScore);
        sb.append(", logicScore=").append(logicScore);
        sb.append(", score=").append(score);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}