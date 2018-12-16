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
@Table(name="t_cod_school_level")
public class LevelEntity  implements Serializable{
	 private static final long serialVersionUID = 1L;
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@Column(name="eeid")
private Integer eeid;
@Column(name="level")
private String level;
@Column(name="num")
private Integer num;
@Column(name="date")
private Date date;

//@Entity
//@Table(name="customer")
//public class CustomerEO implements java.io.Serializable {
//  @OneToMany(cascade={ CascadeType.ALL })
//  @JoinColumn(name="customer_id")
//  private Collection<AddressEO> addresses = new ArrayList<AddressEO>();
//...
//}//@oneToMany注解定义在单个查询返回多个数据上


//@OneToOne(mappedBy="id")
@OneToOne(targetEntity = SchoolDataEntity.class)         
@JoinColumn(name = "id",referencedColumnName = "sid")  //第一个是关联表的id，第二个是本身表的属性
private SchoolDataEntity sData;
public LevelEntity() {}
public LevelEntity(Integer eeid,String level,Integer num,Date date){
	this.eeid = eeid;
	this.level = level;
	this.num = num;
	this.date = date;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

public Integer getEeid() {
	return eeid;
}
public void setEeid(Integer eeid) {
	this.eeid = eeid;
}
public SchoolDataEntity getsData() {
	return sData;
}
public void setsData(SchoolDataEntity sData) {
	this.sData = sData;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	String str = "id="+id.toString()+" date="+date.toString()+" num="+
num.toString()+" level="+level;//+getsData().toString()
	return str;
	
}
}
