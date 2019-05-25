package com.HLXY.dto;

public class SourceReqDto extends PageSelectDto {
	public static final int NOT_CONFIRM = 0;
	public static final int CONFIRM = 1;
	public Integer studentNum;

    public Integer teacherNum;

    public String studentsResource;

    public String createTime;

    public String approve;
    //0未确认，1已确认

	public Integer getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}

	public Integer getTeacherNum() {
		return teacherNum;
	}

	public void setTeacherNum(Integer teacherNum) {
		this.teacherNum = teacherNum;
	}

	public String getStudentsResource() {
		return studentsResource;
	}

	public void setStudentsResource(String studentsResource) {
		this.studentsResource = studentsResource;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	@Override
	public String toString() {
		return "SourceReqDto [studentNum=" + studentNum + ", teacherNum=" + teacherNum + ", studentsResource="
				+ studentsResource + ", createTime=" + createTime + ", approve=" + approve + "]";
	}
    
}
