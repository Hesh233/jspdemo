package com.HLXY.entity;

import java.util.Date;

public class Dirary {


	private Integer id;

    private Integer studentNum;

    private String weekMark;

    private Date createTime;

    private Integer weekNum;

    private Integer lateSumitted;

    private String teacherAppraise;

    private Double score;
    
    private Date updateTime;
    

    public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getWeekMark() {
        return weekMark;
    }

    public void setWeekMark(String weekMark) {
        this.weekMark = weekMark == null ? null : weekMark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public Integer getLateSumitted() {
        return lateSumitted;
    }

    public void setLateSumitted(Integer lateSumitted) {
        this.lateSumitted = lateSumitted;
    }

    public String getTeacherAppraise() {
        return teacherAppraise;
    }

    public void setTeacherAppraise(String teacherAppraise) {
        this.teacherAppraise = teacherAppraise == null ? null : teacherAppraise.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}