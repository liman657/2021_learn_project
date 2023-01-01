package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.util.Date;

public class ImcUser implements Serializable {
    private Integer userId;

    private String userNick;

    private String userPwd;

    private String sex;

    private String province;

    private String city;

    private String position;

    private String mem;

    private Integer expCnt;

    private Integer score;

    private Integer followCnt;

    private Integer fansCnt;

    private Byte isTeacher;

    private Date regTime;

    private Byte userStatus;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick == null ? null : userNick.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem == null ? null : mem.trim();
    }

    public Integer getExpCnt() {
        return expCnt;
    }

    public void setExpCnt(Integer expCnt) {
        this.expCnt = expCnt;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getFollowCnt() {
        return followCnt;
    }

    public void setFollowCnt(Integer followCnt) {
        this.followCnt = followCnt;
    }

    public Integer getFansCnt() {
        return fansCnt;
    }

    public void setFansCnt(Integer fansCnt) {
        this.fansCnt = fansCnt;
    }

    public Byte getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(Byte isTeacher) {
        this.isTeacher = isTeacher;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userNick=").append(userNick);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", sex=").append(sex);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", position=").append(position);
        sb.append(", mem=").append(mem);
        sb.append(", expCnt=").append(expCnt);
        sb.append(", score=").append(score);
        sb.append(", followCnt=").append(followCnt);
        sb.append(", fansCnt=").append(fansCnt);
        sb.append(", isTeacher=").append(isTeacher);
        sb.append(", regTime=").append(regTime);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}