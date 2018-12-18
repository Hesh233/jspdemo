package com.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
 
@Entity
@Table(name="t_cod_school_data")
public class SchoolDataEntity  implements Serializable{
	 private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
//	@OneToOne(targetEntity = LevelEntity.class)         
//	@JoinColumn(name = "eeid",referencedColumnName = "id")
//	private LevelEntity level;
	@Column(name="s_name")
	public String sName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Integer getSchIdentity() {
		return schIdentity;
	}
	public void setSchIdentity(Integer schIdentity) {
		this.schIdentity = schIdentity;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getEduLevel() {
		return eduLevel;
	}
	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}
	public Integer getQqrdpm() {
		return qqrdpm;
	}
	public void setQqrdpm(Integer qqrdpm) {
		this.qqrdpm = qqrdpm;
	}
	public String getLbrdpm() {
		return lbrdpm;
	}
	public void setLbrdpm(String lbrdpm) {
		this.lbrdpm = lbrdpm;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Column(name="sch_dentity")
	private Integer schIdentity;
	@Column(name="province")
	private String province;
	@Column(name="eduLevel")
	private String eduLevel;
	@Column(name="qqrdpm")
	private Integer qqrdpm;
	@Column(name="lbrdpm")
	private String lbrdpm;
	@Column(name="createtime")
	private Date createtime;
	@Override
	public String toString() {
		return "id="+id.toString()+" schIdentity"+schIdentity.toString()
		+" province="+province+" eduLevel="+eduLevel+" qqrdpm="+qqrdpm.toString()
		+" lbrdpm"+lbrdpm+" createtime="+createtime.toString();
	}
}

