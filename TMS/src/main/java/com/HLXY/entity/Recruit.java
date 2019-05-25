package com.HLXY.entity;

import java.util.Date;

public class Recruit {

	private Integer id;

	private String positionName;

	private String companyName;

	private String companyAddress;

	private Date createTime;

	private String interviewPlace;

	private Date startTime;

	private Date endTime;

	private Integer interviewType;

	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress == null ? null : companyAddress.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getInterviewPlace() {
		return interviewPlace;
	}

	public void setInterviewPlace(String interviewPlace) {
		this.interviewPlace = interviewPlace == null ? null : interviewPlace.trim();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(Integer interviewType) {
		this.interviewType = interviewType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "Recruit [id=" + id + ", positionName=" + positionName + ", companyName=" + companyName
				+ ", companyAddress=" + companyAddress + ", createTime=" + createTime + ", interviewPlace="
				+ interviewPlace + ", startTime=" + startTime + ", endTime=" + endTime + ", interviewType="
				+ interviewType + ", remark=" + remark + "]";
	}

}