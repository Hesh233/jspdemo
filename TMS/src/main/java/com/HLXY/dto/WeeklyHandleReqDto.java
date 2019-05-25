package com.HLXY.dto;

public class WeeklyHandleReqDto extends PageSelectDto{
	public Integer id;//周记id
	public Integer studentNum;//学生号
	public String weekMark;//周小结
	public Integer teacherNum;//老师号
	public String appraise;//教师评价
	public Integer weekNum;//周数
	public Double score;//教师评分
	public String studentClass;//学生班级
	
	

	public String getStudentClass() {
		return studentClass;
	}



	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
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
		this.weekMark = weekMark;
	}



	public Integer getTeacherNum() {
		return teacherNum;
	}



	public void setTeacherNum(Integer teacherNum) {
		this.teacherNum = teacherNum;
	}



	public String getAppraise() {
		return appraise;
	}



	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}



	public Integer getWeekNum() {
		return weekNum;
	}



	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}



	public Double getScore() {
		return score;
	}



	public void setScore(Double score) {
		this.score = score;
	}



	@Override
	public String toString() {
		return "WeeklyHandleReqDto [id=" + id + ", studentNum=" + studentNum + ", weekMark=" + weekMark
				+ ", teacherNum=" + teacherNum + ", appraise=" + appraise + ", weekNum=" + weekNum + ", score=" + score
				+ ", studentClass=" + studentClass + "]";
	}




	
}
