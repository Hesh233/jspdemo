package com.springboot.info;
//这个不用看
import java.io.Serializable;

import org.apache.tomcat.jni.Address;

import com.springboot.entity.LevelEntity;
import com.springboot.entity.SchoolDataEntity;

public class ViewInfo implements Serializable {

  private static final long serialVersionUID = -6347911007178390219L;

  private LevelEntity level;
  private SchoolDataEntity schoolData;

  public ViewInfo() {

  }

  public ViewInfo(LevelEntity level) {
	  SchoolDataEntity schoolData = new SchoolDataEntity();
    this.level = level;
    this.schoolData = schoolData;
  }

  public ViewInfo(SchoolDataEntity schoolData) {
	  LevelEntity level = new LevelEntity();
    this.level = level;
    this.schoolData = schoolData;
  }
  public ViewInfo(SchoolDataEntity schoolData, LevelEntity level) {
	    this.schoolData = schoolData;
	    this.level = level;
	  }
  // getter, setter

public LevelEntity getLevel() {
	return level;
}

public void setLevel(LevelEntity level) {
	this.level = level;
}

public SchoolDataEntity getSchoolData() {
	return schoolData;
}

public void setSchoolData(SchoolDataEntity schoolData) {
	this.schoolData = schoolData;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

}
