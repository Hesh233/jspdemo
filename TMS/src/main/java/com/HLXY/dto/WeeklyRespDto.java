package com.HLXY.dto;


public class WeeklyRespDto {
	public Integer id;

	public Integer studentNum;

	public String weekMark;

	public Integer weekNum;

	public Integer lateSumitted;

	public String teacherAppraise;

	public Double score;

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
		this.weekMark = weekMark;
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
		this.teacherAppraise = teacherAppraise;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

    
}
