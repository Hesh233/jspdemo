package com.HLXY.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.HLXY.dao.DiraryMapper;
import com.HLXY.dao.GuideMapper;
import com.HLXY.dto.WeeklyHandleReqDto;
import com.HLXY.entity.Dirary;
import com.HLXY.entity.Guide;
import com.HLXY.service.DayWeeklyService;
import com.HLXY.util.DateUtil;
import com.HLXY.util.ServerException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Service("dayWeeklyService")
public class DayWeeklyServiceImpl implements DayWeeklyService{
	private static final Logger LOGGER=LoggerFactory.getLogger(DayWeeklyServiceImpl.class);
	@Resource
	private DiraryMapper diraryDao;
	@Resource
	private GuideMapper guideMapperDao;
	@Value("${TMS.start.date}")
	private  String startTimeStr;
	@Value("${TMS.continue.week}")
	private  String weekStr;
	@Resource
	private GuideMapper guideDao;
	/**
	 * 老师查询指导记录表
	 */
	@Override
	public JSONObject one_guide(WeeklyHandleReqDto req) {
		LOGGER.info("one_guide.req="+req.toString());
		List<Guide> gu = guideDao.selectByTeacherNumAndWeekAndClass(req.teacherNum,req.weekNum,req.studentClass);
		if (gu.size() == 0) {
			return null;
		} else {
			return (JSONObject) JSONObject.toJSON(gu.get(0));
		}
	}
	/**
	 * 查询老师负责的班级
	 */
	@Override
	public JSONObject teacher_class(Integer teacherNum) {
		String res = guideDao.selectClass(teacherNum);
		if(res != null) {
			String re[] = res.split(",");
			JSONObject jo = new JSONObject();
			for(int i = 0;i<re.length;i++) {
				jo.put(i+"", re[i]);
			}
			return jo;
		}
		return null;
	}
	/**
	 * 老师指导信息提交
	 * 
	 * @param req
	 * @return
	 */
	@Override
	public String guide_handle(WeeklyHandleReqDto req) {
		if(req.weekMark.length() >= 350)throw new ServerException("记录不超过350");
		LOGGER.info("guide_handle.req="+req.toString());
		List<Guide> gulst = guideDao.selectByTeacherNumAndWeekAndClass(req.teacherNum,req.weekNum,req.studentClass);
		if(gulst.size() == 1) {
			Guide guide = gulst.get(0);
			guide.setStudentClass(req.studentClass);
			guide.setUpdataTime(Calendar.getInstance().getTime());
			guide.setWeekMark(req.weekMark);
			guide.setWeekNum(req.weekNum);
			guideDao.updateByPrimaryKeySelective(guide);
		}else if(gulst.size() == 0) {
			Guide guide = new Guide();
			guide.setStudentClass(req.studentClass);
			guide.setCreateTime(Calendar.getInstance().getTime());
			guide.setWeekMark(req.weekMark);
			guide.setWeekNum(req.weekNum);
			guide.setTeacherNum(req.teacherNum);			
			guideDao.insertSelective(guide);
		}		
		return "修改成功";
	}
	/**
	 * 学生周记提交
	 */
	@Override
	public String weekly_handle(WeeklyHandleReqDto reqDto) {
		Calendar cal = Calendar.getInstance();
		Date nowDate = cal.getTime();
		Date startDate = DateUtil.parse(startTimeStr, "yyyy-MM-dd","起始时间");
        long stateTimeLong = startDate.getTime();
        long endTimeLong = nowDate.getTime();
        // TODO计算天数应该重新写
        // 结束时间-开始时间 = 天数
        long day = (endTimeLong-stateTimeLong)/(24*60*60*1000); 
        LOGGER.info("weekly_handle.startDate,day"+" "+" "+startDate+" "+day);
        //在生效时间
        if(day<7*Integer.parseInt(weekStr)) {
        	Integer intDay = (int)day;//过了几天
        	Integer week = intDay/7;//第几周
        	LOGGER.info("weekly_handle.intday"+" "+" "+intDay);
        	/*
        	 * 先查一遍，有数据-更新，否则insert
        	 */
        	Dirary selDir = new Dirary();
        	selDir.setStudentNum(reqDto.getStudentNum());
        	selDir.setWeekNum(week);
        	Dirary seleDir = diraryDao.selectByStuNumAndWeek(reqDto.weekNum,reqDto.studentNum);

        	//保存数据
        	Dirary dir = new Dirary();        	
        	dir.setStudentNum(reqDto.getStudentNum());
        	dir.setWeekNum(week);
        	dir.setCreateTime(nowDate);
        	dir.setWeekMark(reqDto.getWeekMark());
        	dir.setWeekNum(reqDto.weekNum);
        	//更新数据
        	if(seleDir != null) {
        		if(seleDir.getScore() != null) {
        			throw new ServerException("已经打过分不能再提交");
        		}
        		dir.setId(seleDir.getId());
        		dir.setUpdateTime(nowDate);
        		diraryDao.updateByPrimaryKeySelective(dir);
        	}else {
            	if(reqDto.weekNum < week) {
            		//0准时交，1晚交
            		dir.setLateSumitted(1);
            	}else {
            		dir.setLateSumitted(0);
            	}
        		diraryDao.insert(dir);
        	}
        }else {
        	throw new ServerException("周记已结束");
        }
		return "保存成功";
	}
	@Override
	public JSONObject oneWeekly(WeeklyHandleReqDto req) {
		Dirary dir = diraryDao.oneWeekly(req.weekNum,req.studentNum);
		String str = JSON.toJSONString(dir);
		JSONObject jo = JSON.parseObject(str);
		return jo;
	}
	/**
	 * 周记列表
	 */
	@Override
	public JSONArray weeklyList(WeeklyHandleReqDto req) {
		//根据周数查询
//		int count = diraryDao.selectAllCount(req.weekNum,req.teacherNum);
//		int page_temp = req.getPage();
//		int limit = req.getLimit();
//		if (count < req.getPage() * limit) {
//			limit = count - (req.getPage() - 1) * limit;
//		}
		req.page = (req.page - 1) * req.limit;
		//System.out.println(page);
		//排序符号需要转换
		String ascOrdesc = "asc";
		if(req.ascOrDesc == 1) {
			ascOrdesc = "desc";
		}
		List<Map<Object,Object>> weeklyList = diraryDao.selectAllSort(req.teacherNum,req.sortKey,req.page,req.limit,ascOrdesc,req.weekNum);
		String jStr = JSON.toJSONString(weeklyList);
		JSONArray ja = JSONArray.parseArray(jStr);
		return ja;
	}
	@Override
	public Integer weeklyListCount(WeeklyHandleReqDto reqDto) {
		//根据周数查询
		Integer count = diraryDao.selectAllCount(reqDto.weekNum,reqDto.teacherNum);
		return count;
	}
	@Override
	public String teacher_appraise_handle(WeeklyHandleReqDto reqDto) {

		Dirary dir = diraryDao.selectByPrimaryKey(reqDto.id);
		if(dir.getScore() == null) {
			dir.setTeacherAppraise(reqDto.appraise);
			dir.setScore(reqDto.score);
			diraryDao.updateByPrimaryKey(dir);
		}else {
			throw new ServerException("已经点评过了");
		}
		return "提交成功";
	}
	/**
	 * 查学生单条记录
	 */
	@Override
	public Dirary teaApprove(Integer id,Integer seTeacherNum) {
		Dirary dir = diraryDao.selectByPrimaryKey(id);
		Integer teacherNum = diraryDao.teacherNum(dir.getStudentNum());
		if(teacherNum != null && teacherNum != seTeacherNum) {
			throw new ServerException("非法操作");
		}
		return dir;
		
	}
}
