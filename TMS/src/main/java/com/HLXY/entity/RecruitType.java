package com.HLXY.entity;

public class RecruitType {
	private Integer id;
	private String type;
	private String major;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major  == null ? null : major.trim();
	}
	@Override
	public String toString() {
		return "RecruitType [id=" + id + ", type=" + type + ", major=" + major + "]";
	}
	
}
