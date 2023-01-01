package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ImcClassvalue implements Serializable {
    private Integer valueId;

    private Integer userId;

    private Integer courseId;

    private BigDecimal contentScore;

    private BigDecimal levelScore;

    private BigDecimal logicScore;

    private BigDecimal score;

    private Date addTime;

    private BigDecimal totalScore;

    private static final long serialVersionUID = 1L;

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", valueId=").append(valueId);
        sb.append(", userId=").append(userId);
        sb.append(", courseId=").append(courseId);
        sb.append(", contentScore=").append(contentScore);
        sb.append(", levelScore=").append(levelScore);
        sb.append(", logicScore=").append(logicScore);
        sb.append(", score=").append(score);
        sb.append(", addTime=").append(addTime);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}