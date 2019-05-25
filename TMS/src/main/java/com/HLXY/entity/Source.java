package com.HLXY.entity;

import java.util.Date;

public class Source {


	private Integer id;

	private Integer studentNum;

	private Date createTime;

	private Integer approve;

	private String studentsResource;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getApprove() {
		return approve;
	}

	public void setApprove(Integer approve) {
		this.approve = approve;
	}

	public String getStudentsResource() {
		return studentsResource;
	}

	public void setStudentsResource(String studentsResource) {
		this.studentsResource = studentsResource == null ? null : studentsResource.trim();
	}

	
}